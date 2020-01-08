package com.bridgelabz.fellowship.model;

public class StockInventory {
	private String company_name;
	private int share_price;
	private String company_symbol;
	private int company_shares;

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public int getShare_price() {
		return share_price;
	}

	public void setShare_price(int share_price) {
		this.share_price = share_price;
	}

	public String getCompany_symbol() {
		return company_symbol;
	}

	public void setCompany_symbol(String company_symbol) {
		this.company_symbol = company_symbol;
	}

	public int getCompany_shares() {
		return company_shares;
	}

	public void setCompany_shares(int company_shares) {
		this.company_shares = company_shares;
	}

}
