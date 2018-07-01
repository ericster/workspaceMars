/*
 * rmq.cpp
 *
 *  Created on: Mar 27, 2018
 *      Author: Eric
 */

#include<iostream>
#include<limits.h>

using namespace std;
int tree[2000005],a[1000005];
int min(int x,int y)
{
    if(x<y)
    return x;
    else
    return y;
}
void build(int node,int st,int end)
{
    if(st==end)
    {
        tree[node]=a[st];
    }
    else
    {
        int mid=(st+end)/2;
        build(2*node,st,mid);
        build(2*node+1,mid+1,end);
        tree[node]=min(tree[2*node],tree[2*node+1]);
    }
}
void update(int node,int st,int end,int index,int v)
{
    if(st==end)
    {
        a[index]=v;
        tree[node]=v;
    }
    else
    {
        int mid=(st+end)/2;
        if(index>=st && index<=mid)
        {
            update(2*node,st,mid,index,v);
        }
        else
        {
            update(2*node+1,mid+1,end,index,v);
        }
        tree[node]=min(tree[2*node],tree[2*node+1]);
    }
}
int query(int node,int st,int end,int l,int r)
{
    if(l>end || r<st)
    return 10000005;
    if(l<=st && r>=end)
    {
        return tree[node];
    }
    int mid=(st+end)/2;
    int b1=query(2*node,st,mid,l,r);
    int b2=query(2*node+1,mid+1,end,l,r);
    return min(b1,b2);
}
int main()
{
  int n,q,i;
  cin>>n>>q;
  for(i=1;i<=n;i++)
  cin>>a[i];
  build(1,1,n);
  while(q--)
  {
      char ch;
      int x,y;
      cin>>ch>>x>>y;
      if(ch=='u')
      {
          update(1,1,n,x,y);
      }
      else
      {
          int ans=query(1,1,n,x,y);
          cout<<ans<<endl;
      }
  }
  return 0;
}



