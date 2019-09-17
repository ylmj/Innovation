package com.basic.util;

public class systemContext {
	//���������ֲ߳̾�����
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> pageIndex = new ThreadLocal<Integer>();
	
	//set.get.remove �ֱ����ֲ߳̾�������������,��ȡ��ɾ���Ĳ���
	
	public static int getPageSize() {
		return pageSize.get();
	}
	public static void setPageSize(int pageSize) {
		systemContext.pageSize.set(pageSize);
	}
	public static void removePageSize() {
		systemContext.pageSize.remove();
	}
	
	public static int getPageIndex() {
		return pageIndex.get();
	}
	public static void setPageIndex(int pageIndex) {
		systemContext.pageIndex.set(pageIndex);
	}
	public static void removePageIndex() {
		systemContext.pageIndex.remove();
	}
	//ʹ�ÿ�ܷ�ҳ�Ļ�,�ڿͻ��˴��ݹ����Ĳ���������pageIndex , page.Offset
	private static ThreadLocal<Integer> pageOffset = new ThreadLocal<Integer>();
	
	public static int getpageOffset() {
		return pageOffset.get();
	}
	public static void setPageOffset(int pageOffset) {
		systemContext.pageOffset.set(pageOffset);
	}
	public static void removePageOffset() {
		systemContext.pageOffset.remove();
	}
}
