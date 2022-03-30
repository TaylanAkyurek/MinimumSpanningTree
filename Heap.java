public class Heap{
//While I was struggling with implementing the heapify
//method, announcement has changed and we now are 
//permitted to use java's priority queue so I stopped
//working on this

public Edge edgeHeap[];
int size;
int edgeCount;

public Heap(int edgeCount){

this.edgeCount=edgeCount;
this.size=0;
this.edgeHeap = new Edge[edgeCount+1];
Edge fill=new Edge(" "," ",-1000, -1000);
edgeHeap[0]=fill;

}

public int getParent(int index){

return index/2;

}
public int getLeft(int index){

return index*2;

}
public int getRight(int index){

return (2*index)+1;

}
public void swapEdge(int i, int j){

  Edge temp= edgeHeap[i];

  edgeHeap[i]=edgeHeap[j];
  edgeHeap[j]=temp;
}
public void heapify(int index){
  int minChildIndex=-1;
  if(index>((size)/2)&&index<=(size)){
            
    return;
  }
  if(edgeHeap[getRight(index)]==null||edgeHeap[getRight(index)].cost>edgeHeap[getLeft(index)].cost){

    minChildIndex=getLeft(index);
  }
  else{
    minChildIndex=getRight(index);
  }
  System.out.println(minChildIndex);
  if(edgeHeap[index].cost<edgeHeap[minChildIndex].cost){
    return;
  }
  else{
    swapEdge(index,minChildIndex);
    heapify(minChildIndex);
  }
  
}

public void insert(Edge e){

if(size == edgeCount){
  
  return;
}
size++;
edgeHeap[size]=e;
int temp=size;
int index=temp;
while(edgeHeap[temp].cost<edgeHeap[getParent(temp)].cost){

swapEdge(temp,getParent(temp));

temp=getParent(temp);
} 

}

public Edge removeMin(){
if(size==0){
  return null;
}
Edge temp=edgeHeap[1];
swapEdge(1,size);
edgeHeap[size--]=null;
heapify(1);
return temp;
}

}