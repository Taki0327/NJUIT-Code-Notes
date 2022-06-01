# Scrapy

## 安装前提

已安装好python环境

## 安装Scrapy

```shell
# 安装Scrapy
C:\>pip install Scrapy

# 查看安装
C:\>pip list
Scrapy                 2.4.1

# 可执行文件目录
C:\>where scrapy
C:\Users\jiale\AppData\Local\Programs\Python\Python38\Scripts\scrapy.exe

# 命令使用方法
C:\>scrapy
Scrapy 2.4.1 - no active project

Usage:
  scrapy <command> [options] [args]

Available commands:
  bench         Run quick benchmark test
  commands
  fetch         Fetch a URL using the Scrapy downloader
  genspider     Generate new spider using pre-defined templates
  runspider     Run a self-contained spider (without creating a project)
  settings      Get settings values
  shell         Interactive scraping console
  startproject  Create new project
  version       Print Scrapy version
  view          Open URL in browser, as seen by Scrapy

  [ more ]      More commands available when run from project directory

Use "scrapy <command> -h" to see more info about a command
```

## 先跑个小例子

1. 创建 quotes_spider.py

   ```python
   import scrapy
   
   class QuotesSpider(scrapy.Spider):
       name = 'quotes'
       start_urls = [
           'http://quotes.toscrape.com/tag/humor/',
       ]
   
       def parse(self, response):
           for quote in response.css('div.quote'):
               yield {
                   'author': quote.xpath('span/small/text()').get(),
                   'text': quote.css('span.text::text').get(),
               }
   
           next_page = response.css('li.next a::attr("href")').get()
           if next_page is not None:
               yield response.follow(next_page, self.parse)
   ```
   
2. 执行爬虫命令

   ```shell
   E:\>scrapy runspider quotes_spider.py -o quotes.jl
   ......
   2021-03-30 15:55:32 [scrapy.core.scraper] DEBUG: Scraped from <200 http://quotes.toscrape.com/tag/humor/>
   {'author': 'Jane Austen', 'text': '“The person, be it gentleman or lady, who has not pleasure in a good novel, must be intolerably stupid.”'}
   2021-03-30 15:55:32 [scrapy.core.scraper] DEBUG: Scraped from <200 http://quotes.toscrape.com/tag/humor/>
   {'author': 'Steve Martin', 'text': '“A day without sunshine is like, you know, night.”'}
   2021-03-30 15:55:32 [scrapy.core.scraper] DEBUG: Scraped from <200 http://quotes.toscrape.com/tag/humor/>
   ......
   ```

3. 查看结果文件

   ```shell
   E:\>type quotes.jl
   {"author": "Jane Austen", "text": "\u201cThe person, be it gentleman or lady, who has not pleasure in a good novel, must be intolerably stupid.\u201d"}
   {"author": "Steve Martin", "text": "\u201cA day without sunshine is like, you know, night.\u201d"}
   {"author": "Garrison Keillor", "text": "\u201cAnyone who thinks sitting in church can make you a Christian must also think that sitting in a garage can make you a car.\u201d"}
   ......
   ```

## 简单教程

1. 创建工程

   ```shell
   # 创建工程
   scrapy startproject tutorial
   
   # 观察生成的项目目录文件
   ```

   ![image-20210330164441133](img/image-20210330164441133.png)

2. 第一个爬虫

   在目录 tutorial/spiders 中新建文件 quotes_spider.py 

   ```python
   import scrapy
   
   
   class QuotesSpider(scrapy.Spider):
       name = "quotes"
   
       def start_requests(self):
           urls = [
               'http://quotes.toscrape.com/page/1/',
               'http://quotes.toscrape.com/page/2/',
           ]
           for url in urls:
               yield scrapy.Request(url=url, callback=self.parse)
   
       def parse(self, response):
           page = response.url.split("/")[-2]
           filename = f'quotes-{page}.html'
           with open(filename, 'wb') as f:
               f.write(response.body)
           self.log(f'Saved file {filename}')
   ```

3. 运行爬虫

   进入项目tutorial的根目录，执行命令

   ```shell
   E:\南工院\课程-大数据\introduction-to-big-data\src\main\python\tutorial>scrapy crawl quotes
   ......
   2021-03-30 16:50:54 [scrapy.core.engine] INFO: Spider opened
   2021-03-30 16:50:54 [scrapy.extensions.logstats] INFO: Crawled 0 pages (at 0 pages/min), scraped 0 items (at 0 items/min)
   2021-03-30 16:50:54 [scrapy.extensions.telnet] INFO: Telnet console listening on 127.0.0.1:6023
   2021-03-30 16:50:54 [scrapy.core.engine] DEBUG: Crawled (404) <GET http://quotes.toscrape.com/robots.txt> (referer: None)
   2021-03-30 16:50:54 [scrapy.core.engine] DEBUG: Crawled (200) <GET http://quotes.toscrape.com/page/1/> (referer: None)
   2021-03-30 16:50:54 [quotes] DEBUG: Saved file quotes-1.html
   2021-03-30 16:50:55 [scrapy.core.engine] DEBUG: Crawled (200) <GET http://quotes.toscrape.com/page/2/> (referer: None)
   2021-03-30 16:50:55 [quotes] DEBUG: Saved file quotes-2.html
   2021-03-30 16:50:55 [scrapy.core.engine] INFO: Closing spider (finished)
   ......
   
   ```

   可以看到爬下网页内容，并保存到本地。

   可以打开本地文件看看。

   
## Scrapy Shell

1. 简介

   Scrapy shell也称"Scrapy终端"，是一个交互终端，使我们可以在未启动spider爬虫的情况下尝试及调试代码。

   我们可以直接用来测试XPath或CSS表达式，而不用import导入相应模块。

   通过查看其运行的结果，方便了我们分析目标网页，并从中测试我们的表达式是否提取到了数据。

2. 启动

   ```shell
   # 打开scrapy shell
   scrapy shell "http://quotes.toscrape.com/page/1/"
   
   [s] Available Scrapy objects:
   [s]   scrapy     scrapy module (contains scrapy.Request, scrapy.Selector, etc)
   [s]   crawler    <scrapy.crawler.Crawler object at 0x00000156A8F921C0>
   [s]   item       {}
   [s]   request    <GET http://quotes.toscrape.com/page/1/>
   [s]   response   <200 http://quotes.toscrape.com/page/1/>
   [s]   settings   <scrapy.settings.Settings object at 0x00000156A8F92250>
   [s]   spider     <DefaultSpider 'default' at 0x156a9d34580>
   [s] Useful shortcuts:
   [s]   fetch(url[, redirect=True]) Fetch URL and update local objects (by default, redirects are followed)
   [s]   fetch(req)                  Fetch a scrapy.Request and update local objects
   [s]   shelp()           Shell help (print this help)
   [s]   view(response)    View response in a browser
   ```

3. 获取信息

   ```shell
   # cssy元素选择器
   In [1]: response.css('title')
   Out[1]: [<Selector xpath='descendant-or-self::title' data='<title>Quotes to Scrape</title>'>]
   
   # 获取标签的text
   In [2]: response.css('title::text').getall()
   Out[2]: ['Quotes to Scrape']
   
   # 获取所有getall
   In [3]: response.css('title').getall()
   Out[3]: ['<title>Quotes to Scrape</title>']
   
   # 获取首个get
   In [4]: response.css('title::text').get()
   Out[4]: 'Quotes to Scrape'
   
   # 索引
   In [5]: response.css('title::text')[0].get()
   Out[5]: 'Quotes to Scrape'
   
   # 正则
   In [6]: response.css('title::text').re(r'Quotes.*')
   Out[6]: ['Quotes to Scrape']
   
   In [7]: response.css('title::text').re(r'Q\w+')
   Out[7]: ['Quotes']
   
   In [8]: response.css('title::text').re(r'(\w+) to (\w+)')
   Out[8]: ['Quotes', 'Scrape']
   
   # xpath 标签选择器
   In [9]: response.xpath('//title')
   Out[9]: [<Selector xpath='//title' data='<title>Quotes to Scrape</title>'>]
   
   In [10]: response.xpath('//title/text()').get()
   Out[10]: 'Quotes to Scrape'
   
   
   ```

4. 获取作者和名言

   ```shell
   # 元素选择器+class选择器。根据div.quote获取到selector列表，即选取class=quate的div
   In [1]: response.css("div.quote")
   Out[1]:
   [<Selector xpath="descendant-or-self::div[@class and contains(concat(' ', normalize-space(@class), ' '), ' quote ')]" data='<div class="quote" itemscope itemtype...'>,
   <Selector xpath="descendant-or-self::div[@class and contains(concat(' ', normalize-space(@class), ' '), ' quote ')]" data='<div class="quote" itemscope itemtype...'>,
   <Selector xpath="descendant-or-self::div[@class and contains(concat(' ', normalize-space(@class), ' '), ' quote ')]" data='<div class="quote" itemscope itemtype...'>,
   <Selector xpath="descendant-or-self::div[@class and contains(concat(' ', normalize-space(@class), ' '), ' quote ')]" data='<div class="quote" itemscope itemtype...'>,
   <Selector xpath="descendant-or-self::div[@class and contains(concat(' ', normalize-space(@class), ' '), ' quote ')]" data='<div class="quote" itemscope itemtype...'>,
   <Selector xpath="descendant-or-self::div[@class and contains(concat(' ', normalize-space(@class), ' '), ' quote ')]" data='<div class="quote" itemscope itemtype...'>,
   <Selector xpath="descendant-or-self::div[@class and contains(concat(' ', normalize-space(@class), ' '), ' quote ')]" data='<div class="quote" itemscope itemtype...'>,
   <Selector xpath="descendant-or-self::div[@class and contains(concat(' ', normalize-space(@class), ' '), ' quote ')]" data='<div class="quote" itemscope itemtype...'>,
   <Selector xpath="descendant-or-self::div[@class and contains(concat(' ', normalize-space(@class), ' '), ' quote ')]" data='<div class="quote" itemscope itemtype...'>,
   <Selector xpath="descendant-or-self::div[@class and contains(concat(' ', normalize-space(@class), ' '), ' quote ')]" data='<div class="quote" itemscope itemtype...'>]
   
   # 索引0，第一个元素
   In [2]: quote = response.css("div.quote")[0]
   
   # 名言 class=text的span
   In [3]: text = quote.css("span.text::text").get()
   
   In [4]: text
   Out[4]: '“The world as we have created it is a process of our thinking. It cannot be changed without changing our thinking.”'
   
   # 标注 class=tags的div，进一步选clas=tag的a
   In [5]: tags = quote.css("div.tags a.tag::text").getall()
   
   In [6]: tags
   Out[6]: ['change', 'deep-thoughts', 'thinking', 'world']
   
   # 打印出所有的名言、作者、标注
   In [8]: for quote in response.css("div.quote"):
   ...:      text = quote.css("span.text::text").get()
   ...:      author = quote.css("small.author::text").get()
   ...:      tags = quote.css("div.tags a.tag::text").getall()
   ...:      print(dict(text=text, author=author, tags=tags))
   ...:
   {'text': '“The world as we have created it is a process of our thinking. It cannot be changed without changing our thinking.”', 'author': 'Albert Einstein', 'tags': ['change', 'deep-thoughts', 'thinking', 'world']}
   {'text': '“It is our choices, Harry, that show what we truly are, far more than our abilities.”', 'author': 'J.K. Rowling', 'tags': ['abilities', 'choices']}
   {'text': '“There are only two ways to live your life. One is as though nothing is a miracle. The other is as though everything is a miracle.”', 'author': 'Albert Einstein', 'tags': ['inspirational', 'life', 'live', 'miracle', 'miracles']}
   {'text': '“The person, be it gentleman or lady, who has not pleasure in a good novel, must be intolerably stupid.”', 'author': 'Jane Austen', 'tags': ['aliteracy', 'books', 'classic', 'humor']}
   {'text': "“Imperfection is beauty, madness is genius and it's better to be absolutely ridiculous than absolutely boring.”", 'author': 'Marilyn Monroe', 'tags': ['be-yourself', 'inspirational']}
   {'text': '“Try not to become a man of success. Rather become a man of value.”', 'author': 'Albert Einstein', 'tags': ['adulthood', 'success', 'value']}
   {'text': '“It is better to be hated for what you are than to be loved for what you are not.”', 'author': 'André Gide', 'tags': ['life', 'love']}
   {'text': "“I have not failed. I've just found 10,000 ways that won't work.”", 'author': 'Thomas A. Edison', 'tags': ['edison', 'failure', 'inspirational', 'paraphrased']}
   {'text': "“A woman is like a tea bag; you never know how strong it is until it's in hot water.”", 'author': 'Eleanor Roosevelt', 'tags': ['misattributed-eleanor-roosevelt']}
   {'text': '“A day without sunshine is like, you know, night.”', 'author': 'Steve Martin', 'tags': ['humor', 'obvious', 'simile']}
   ```

   

5. 选择器总结

   ```shell
   # 爬取 https://docs.scrapy.org/en/latest/_static/selectors-sample1.html
   # 内容如下：
   <html>
   <head>
   <base href='http://example.com/' />
   <title>Example website</title>
   </head>
   <body>
   <div id='images'>
   <a href='image1.html'>Name: My image 1 <br /><img src='image1_thumb.jpg' /></a>
   <a href='image2.html'>Name: My image 2 <br /><img src='image2_thumb.jpg' /></a>
   <a href='image3.html'>Name: My image 3 <br /><img src='image3_thumb.jpg' /></a>
   <a href='image4.html'>Name: My image 4 <br /><img src='image4_thumb.jpg' /></a>
   <a href='image5.html'>Name: My image 5 <br /><img src='image5_thumb.jpg' /></a>
   </div>
   </body>
   </html>
   
   # 打开scrapy shell
   
   scrapy shell https://docs.scrapy.org/en/latest/_static/selectors-sample1.html
   
   # xpath 元素选择器
   In [1]: response.xpath('//title/text()')
   Out[1]: [<Selector xpath='//title/text()' data='Example website'>]
   
   In [2]: response.xpath('//title/text()').getall()
   Out[2]: ['Example website']
   
   In [3]: response.xpath('//title/text()').get()
   Out[3]: 'Example website'
   
   # xpath id选择器
   In [1]: response.xpath('//div[@id="images"]')
   Out[1]: [<Selector xpath='//div[@id="images"]' data='<div id="images">\n   <a href="image1....'>]
   
   In [2]: response.xpath('//div[@id="images"]/a')
   Out[2]:
   [<Selector xpath='//div[@id="images"]/a' data='<a href="image1.html">Name: My image ...'>,
   <Selector xpath='//div[@id="images"]/a' data='<a href="image2.html">Name: My image ...'>,
   <Selector xpath='//div[@id="images"]/a' data='<a href="image3.html">Name: My image ...'>,
   <Selector xpath='//div[@id="images"]/a' data='<a href="image4.html">Name: My image ...'>,
   <Selector xpath='//div[@id="images"]/a' data='<a href="image5.html">Name: My image ...'>]
   
   In [5]: response.xpath('//div[@id="images"]/a/text()')
   Out[5]:
   [<Selector xpath='//div[@id="images"]/a/text()' data='Name: My image 1 '>,
   <Selector xpath='//div[@id="images"]/a/text()' data='Name: My image 2 '>,
   <Selector xpath='//div[@id="images"]/a/text()' data='Name: My image 3 '>,
   <Selector xpath='//div[@id="images"]/a/text()' data='Name: My image 4 '>,
   <Selector xpath='//div[@id="images"]/a/text()' data='Name: My image 5 '>]
   
   In [6]: response.xpath('//div[@id="images"]/a/text()').getall()
   Out[6]:
   ['Name: My image 1 ',
   'Name: My image 2 ',
   'Name: My image 3 ',
   'Name: My image 4 ',
   'Name: My image 5 ']
   
   # xpath 选取属性
   In [12]: response.xpath('//base/@href').get()
   Out[12]: 'http://example.com/'
   
   In [13]: response.xpath('//div[@id="images"]/a/@href').getall()
   Out[13]: ['image1.html', 'image2.html', 'image3.html', 'image4.html', 'image5.html']
   
   In [14]: response.xpath('//div[@id="images"]/a/img').getall()
   Out[14]:
   ['<img src="image1_thumb.jpg">',
   '<img src="image2_thumb.jpg">',
   '<img src="image3_thumb.jpg">',
   '<img src="image4_thumb.jpg">',
   '<img src="image5_thumb.jpg">']
   
   In [15]: response.xpath('//div[@id="images"]/a/img/@src').getall()
   Out[15]:
   ['image1_thumb.jpg',
   'image2_thumb.jpg',
   'image3_thumb.jpg',
   'image4_thumb.jpg',
   'image5_thumb.jpg']
   
   
   # css 元素选择器
   In [4]: response.css('title::text').get()
   Out[4]: 'Example website'
   
   In [16]: response.css('div')
   Out[16]: [<Selector xpath='descendant-or-self::div' data='<div id="images">\n   <a href="image1....'>]
   
   In [17]: response.css('a')
   Out[17]:
   [<Selector xpath='descendant-or-self::a' data='<a href="image1.html">Name: My image ...'>,
   <Selector xpath='descendant-or-self::a' data='<a href="image2.html">Name: My image ...'>,
   <Selector xpath='descendant-or-self::a' data='<a href="image3.html">Name: My image ...'>,
   <Selector xpath='descendant-or-self::a' data='<a href="image4.html">Name: My image ...'>,
   <Selector xpath='descendant-or-self::a' data='<a href="image5.html">Name: My image ...'>]
   
   # css id选择器
   In [18]: response.css('#images')
   Out[18]: [<Selector xpath="descendant-or-self::*[@id = 'images']" data='<div id="images">\n   <a href="image1....'>]
   
   # css id选择器、元素选择器 组合
   In [21]: response.css('#images a')
   Out[21]:
   [<Selector xpath="descendant-or-self::*[@id = 'images']/descendant-or-self::*/a" data='<a href="image1.html">Name: My image ...'>,
   <Selector xpath="descendant-or-self::*[@id = 'images']/descendant-or-self::*/a" data='<a href="image2.html">Name: My image ...'>,
   <Selector xpath="descendant-or-self::*[@id = 'images']/descendant-or-self::*/a" data='<a href="image3.html">Name: My image ...'>,
   <Selector xpath="descendant-or-self::*[@id = 'images']/descendant-or-self::*/a" data='<a href="image4.html">Name: My image ...'>,
   <Selector xpath="descendant-or-self::*[@id = 'images']/descendant-or-self::*/a" data='<a href="image5.html">Name: My image ...'>]
   
   
   # css 选取属性
   In [13]: response.css('base::attr(href)').get()
   Out[13]: 'http://example.com/'
   
   In [25]: response.css('#images a::attr(href)')
   Out[25]:
   [<Selector xpath="descendant-or-self::*[@id = 'images']/descendant-or-self::*/a/@href" data='image1.html'>,
   <Selector xpath="descendant-or-self::*[@id = 'images']/descendant-or-self::*/a/@href" data='image2.html'>,
   <Selector xpath="descendant-or-self::*[@id = 'images']/descendant-or-self::*/a/@href" data='image3.html'>,
   <Selector xpath="descendant-or-self::*[@id = 'images']/descendant-or-self::*/a/@href" data='image4.html'>,
   <Selector xpath="descendant-or-self::*[@id = 'images']/descendant-or-self::*/a/@href" data='image5.html'>]
   ```

    

5. 选择器语法参考
   1. https://www.w3school.com.cn/css/css_selectors.asp
   2. https://www.w3school.com.cn/xpath/xpath_syntax.asp

# 练习

1. HTTP协议
   1. 使用 curl 命令查看网页代码
   2. 使用 tcpdump 命令观察任意网站报文
      1. 命令参考：tcpdump -i enp0s8 -vvv
      2. 保存文件：tcpdump -i enp0s8 -vvv -w mydump.cap
   3. 使用 浏览器开发者工具查看网页源码
   4. 使用 浏览器开发者工具查看HTTP报文，观察 get、post等不同请求的报文差异
   5. 使用 WireShark，查看tcpdump 抓取的报文文件。
   6. 使用 WireShark，抓取本机浏览网页的报文，并查看。过滤表达式：tcp.port == 80
2. 使用Scrapy Shell，爬取 http://news.niit.edu.cn/4004/list.htm
   1. 爬取内容
      1. 页面标题
      2. 通知标题
      3. 发布时间
      4. 下一页链接地址
   2. 编写爬虫代码，爬取3页通知信息，保存到文件。包括：通知标题、发布时间、通知内容（可选）
3. 使用Scrapy Shell，爬取 http://data.sports.sohu.com/nba/nba_team_info.php?teamid=4

   1. 爬取内容
      1. 姓名
      2. 位置
      3. 身高
      4. 体重
      5. 出生日期
      6. 学校
   2. 编写爬虫代码，爬取相关内容，保存到文件
4. （可选）把爬取的信息保存到 MYSQL 或者 HDFS 

# 参考

https://docs.scrapy.org/en/latest/index.html