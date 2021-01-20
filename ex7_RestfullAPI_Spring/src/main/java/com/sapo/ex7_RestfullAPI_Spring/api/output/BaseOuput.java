package com.sapo.ex7_RestfullAPI_Spring.api.output;

import java.util.ArrayList;
import java.util.List;

public class BaseOuput<T> {
   private int page;
   private int totalPage;
   private List<T> listResult = new ArrayList<>();
public int getPage() {
	return page;
}
public void setPage(int page) {
	this.page = page;
}
public int getTotalPage() {
	return totalPage;
}
public void setTotalPage(int d) {
	this.totalPage = d;
}
public List<T> getListResult() {
	return listResult;
}
public void setListResult(List<T> listResult) {
	this.listResult = listResult;
}
   
}
