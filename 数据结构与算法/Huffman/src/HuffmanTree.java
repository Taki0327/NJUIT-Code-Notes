import java.io.Console;

public class HuffmanTree {
    private String charset;
    private TriElement[] element;
    public HuffmanTree(int[] weights)
    {
        this.charset="";
        int n=weights.length;
        for(int i=0;i<weights.length;i++)
        {
            this.charset+=(char)('A'+i);
        }
        this.element=new TriElement[2*n-1];
        for(int i=0;i<n;i++)
        {
            //创建Trielement对象值为weights数组的i项 赋值给element数组 
            this.element[i]=new TriElement(weights[i]);
        }
        for(int i=n;i<2*n-1;i++)
        {
            int min1=Integer.MAX_VALUE, min2=min1;
            int x1=-1,x2=-1;
            for(int j=0;j<i;j++)
            {
                if(this.element[j].parent==-1)
                {
                    if(this.element[j].data<min1)
                    {
                        min2=min1;
                        x2=x1;
                        min1=this.element[j].data;
                        x1=j;
                    }
                    else if(this.element[j].data<min2)
                    {
                        min2=element[j].data;
                        x2=j;
                    }
                }
            }
            this.element[x1].parent=i;
            this.element[x2].parent=i;
            this.element[i]=new TriElement(min1+min2,-1,x1,x2);
        }
    }

    private String huffmanCode(int i)
    {
        int n=8;
        char code[]=new char[n];
        int child=i,parent=this.element[child].parent;
        for(i=n-1;parent!=-1;i--)
        {
            if(element[parent].left==child)
            {
                code[i]='0';
            }
            else
            {
                code[i]='1';
            }
            child=parent;
            parent=element[child].parent;
        }
        return new String(code,i+1,n-1-i);
    }
    public String toString()
    {
        String str="Huffman树的结点数组：";
        for(int i=0;i<this.element.length;i++)
        {
            str+=this.element[i].toString()+", ";
        }
        str+="\n huffman编码：";
        for(int i=0;i<this.charset.length();i++)
        {
            str+=this.charset.charAt(i)+"："+huffmanCode(i)+", ";
        }
        return str;
    }
}
class huffmanTest{
    public static void main(String[] args) {
        int[] weights={7,5,1,2};
        HuffmanTree huftree=new HuffmanTree(weights);
        System.out.println(huftree.toString());
    }
}
