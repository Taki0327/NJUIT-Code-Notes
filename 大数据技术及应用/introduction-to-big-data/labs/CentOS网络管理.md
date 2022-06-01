1. 网卡配置文件路径及说明

   ```shell
   [root@localhost network-scripts]# pwd
   /etc/sysconfig/network-scripts
   [root@localhost network-scripts]# cat  ifcfg-enp0s3
   TYPE=Ethernet                                 #网卡类型：为以太网
   PROXY_METHOD=none	                          #代理方式：关闭状态
   BROWSER_ONLY=no                                #只是浏览器：否
   BOOTPROTO=static                               #网卡的引导协议：DHCP(动态协议)、static（静态协议）、none（不指定）
   DEFROUTE=yes                                   #默认路由：是
   IPV4_FAILURE_FATAL=no                          #是不开启IPV4致命错误检测：否
   IPV6INIT=yes                                   #IPV6是否自动初始化: 是
   IPV6_AUTOCONF=yes                              #IPV6是否自动配置：是
   IPV6_DEFROUTE=yes                              #IPV6是否可以为默认路由：是
   IPV6_FAILURE_FATAL=no                          #是不开启IPV6致命错误检测：否
   IPV6_ADDR_GEN_MODE=stable-privacy              #IPV6地址生成模型：stable-privacy
   NAME=enp0s8                                    #网卡物理设备名称
   UUID=9691ca69-b8f5-42d2-a3c9-19168b44bf9c      #通用唯一识别码, 每一个网卡都会有, 不能重复, 否两台linux只有一台网卡可用
   DEVICE=enp0s8                                  #网卡设备名称, 必须和 `NAME` 值一样
   ONBOOT=yes                                     #是否开机启动
   IPADDR=192.168.56.100			 			 #IP地址
   NETMASK=255.255.255.0			 			 #子网掩码
   GATEWAY=192.168.56.1			 			 #网关
   ```

2. CentOS网络管理命令 nmcli

   ```shell
   [hadoop@localhost ~]$ nmcli --help
   Usage: nmcli [OPTIONS] OBJECT { COMMAND | help }
   
   OPTIONS
     -a, --ask                                ask for missing parameters
     -c, --colors auto|yes|no                 whether to use colors in output
     -e, --escape yes|no                      escape columns separators in values
     -f, --fields <field,...>|all|common      specify fields to output
     -g, --get-values <field,...>|all|common  shortcut for -m tabular -t -f
     -h, --help                               print this help
     -m, --mode tabular|multiline             output mode
     -o, --overview                           overview mode
     -p, --pretty                             pretty output
     -s, --show-secrets                       allow displaying passwords
     -t, --terse                              terse output
     -v, --version                            show program version
     -w, --wait <seconds>                     set timeout waiting for finishing operations
   
   OBJECT
     g[eneral]       NetworkManager's general status and operations
     n[etworking]    overall networking control
     r[adio]         NetworkManager radio switches
     c[onnection]    NetworkManager's connections
     d[evice]        devices managed by NetworkManager
     a[gent]         NetworkManager secret agent or polkit agent
     m[onitor]       monitor NetworkManager changes
   ```

3. nmcli 样例

   1. 查询操作

      查询服务器所有网卡

      nmcli connection show

      查看正在使用的网卡

      nmcli connection show -active

      查看指定网卡信息详情

      nmcli connection show 设备名称
      查看所有网络设备状态
      nmcli device status
      查看所有网络设备状态详情
      nmcli device show
      查看指定网络设备状态详情
      nmcli device show 设备名称

   2. 启停操作

      重新加载网络配置文件，生效

      nmcli connection reload

      nmcli connection up ens33

      启用网络设备连接

      nmcli connection up 设备名称
      实例：nmcli connection up ens33

      停用网络连接、可以被自动激活

      nmcli connection down 设备名称
      实例：nmcli connection up ens33

      停用网络连接，禁止被激活

      nmcli device disconnect 设备名称
      实例：nmcli device disconnect ens33

      

   3. 修改操作

      创建DHCP类型网络设备、新建配置文件

      nmcli connection add con-name "连接名" type 设备类型 ifname 设备名称
      实例：nmcli connection add con-name "dhcp" type ethernet ifname ens33

      创建静态类型网络设备、新建配置文件、添加IP地址、添加网关。    ↓面单独拿出来详解

      nmcli connection add con-name "连接名" ifname 设备名称 autoconnect no type 设备类型 ip4 IP地址 gw4 网关地址
      实例：nmcli connection add con-name "static" ifname ens33 autoconnect no type ethernet ip4 192.168.1.240 gw4 192.168.1.1
      注：autoconnect 为是否开启网络设备。
      对应配置文件： autoconnect no/yes  |  ONBOOT=no/yes

      修该模式为手动（static）

      nmcli connection modify 设备名称 ipv4.method manual ipv4.addresses IP地址/网关
      实例：nmcli connection modify ens33 ipv4.method manual ipv4.addresses 192.168.1.10/24
      注：原本DHCP模式需要手动添加IP地址，不然会报错。
      对应配置文件：ipv4.method manual/auto  |  BOOTPROTO=static/dhcp

      修该模式为自动（dhcp）

      nmcli connection modify 设备名称 ipv4.method auto
      实例：nmcli connection modify ens33 ipv4.method auto
      对应配置文件：ipv4.method manual/auto  |  BOOTPROTO=static/dhcp

      修该IP地址

      nmcli connection modify 设备名称 ipv4.addresses IP地址/网关
      实例：nmcli connection modify ens33 ipv4.addresses 192.168.1.10/24
      对应配置文件：ipv4.addresses x.x.x.x/x  |  IPADDR=x.x.x.x 、PREFIX=x

      修该网关

      nmcli connection modify 设备名称 ipv4.gateway 网关地址
      实例：nmcli connection modify ens33 ipv4.gateway 192.168.1.1
      对应配置文件：ipv4.gateway x.x.x.x  |  GATEWAY=x.x.x.x

      已创建静态网络设备、添加DNS

      nmcli connection modify 设备名称 ipv4.dns DNS地址
      实例：nmcli connection modify ens33 ipv4.dns 8.8.8.8
      对应配置文件：ipv4.dns x.x.x.x  |  DNS=x.x.x.x

   4. 删除操作

      删除网络连接配置文件

      nmcli connection delete 设备名称
      实例：nmcli connection delete ens33
