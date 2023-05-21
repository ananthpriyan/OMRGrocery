package com.pagemanager;

import com.payload.AddressPayload;
import com.payload.ProductPayload;

/**
 * 
 * @author Anandharaj
 * @Date 03-05-2023
 * @see used to add payload manager
 *
 */
public class PayloadManager {
	
	
	private AddressPayload addresspayload;
	private ProductPayload productpayload;
	
	public AddressPayload getAddresspayload() {
		return (addresspayload==null)? addresspayload=new AddressPayload():addresspayload;
	}
	public ProductPayload getProductpayload() {
		return (productpayload==null)? productpayload=new ProductPayload():productpayload;
	}
	

}
