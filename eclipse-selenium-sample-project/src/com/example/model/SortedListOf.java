package com.example.model;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.google.common.collect.ForwardingList;
import com.google.common.collect.Lists;

public class SortedListOf<T extends Comparable<T>> extends ForwardingList<T> {

  private List<T> list = Lists.newArrayList();
  
  public SortedListOf() {
  }

  public SortedListOf(SortedListOf<T> listToCopy) {
    list = Lists.newArrayList(listToCopy.list);
    Collections.sort(list);
  }

  public SortedListOf(List<T> listToCopy) {
    list = Lists.newArrayList(listToCopy);
    Collections.sort(list);
  }

  @Override
  protected List<T> delegate() {
    return list;
  }

  public SortedListOf<T> withAdded(T item) {
    SortedListOf<T> newItems = new SortedListOf<T>();
    newItems.list = Lists.newArrayList(this.list);
    newItems.list.add(item);
    Collections.sort(newItems.list);
    return newItems;
  }

  public SortedListOf<T> without(T item) {
    SortedListOf<T> newItems = new SortedListOf<T>();
    newItems.list = Lists.newArrayList(this.list);
    newItems.list.remove(item);
    return newItems;
  }

  public T getSome() {
    if (size() == 0) {
      return null;
    } else {
      return list.get(new Random().nextInt(size()));
    }
  }
  
}
