
package com.payload;

import com.pojo.address.AddUserAddress_Input_Pojo;
import com.pojo.address.Citylist_Input_Pojo;
import com.pojo.address.DeleteUserAdd_Input_pojo;
import com.pojo.address.UpdateUserAddress_Input_Pojo;

/**
 * 
 * @author Anandharaj
 * @Date 03-05-2023
 * @see used to add payload data
 *
 */
public class AddressPayload {

	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param mobile
	 * @param apartment
	 * @param stateid
	 * @param cityid
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param addresstype
	 * @return
	 * @see used to addUserAddresspayload
	 */
	public AddUserAddress_Input_Pojo addUserAddress(String firstname, String lastname, String mobile, String apartment,
			int stateid, int cityid, int country, String zipcode, String address, String addresstype) {

		AddUserAddress_Input_Pojo address_Input_Pojo = new AddUserAddress_Input_Pojo(firstname, lastname, mobile,
				apartment, stateid, cityid, country, zipcode, address, addresstype);
		return address_Input_Pojo;

	}
/**
 * 
 * @param addressId
 * @param firstname
 * @param lastname
 * @param mobile
 * @param apartment
 * @param stateid
 * @param cityid
 * @param country
 * @param zipcode
 * @param address
 * @param addresstype
 * @return
 * @see used to updateUserAddressPayload
 */
	public UpdateUserAddress_Input_Pojo updateUserAddress(String addressId, String firstname, String lastname,
			String mobile, String apartment, int stateid, int cityid, int country, String zipcode, String address,
			String addresstype) {

		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo = new UpdateUserAddress_Input_Pojo(addressId,
				firstname, lastname, mobile, apartment, stateid, cityid, country, zipcode, address, addresstype);

		return updateUserAddress_Input_Pojo;
	}
	
	
	
	
	public Citylist_Input_Pojo cityList(String stateid) {
		
		Citylist_Input_Pojo citylist_Input_Pojo = new Citylist_Input_Pojo(stateid);

		return citylist_Input_Pojo;
	}

	
	public DeleteUserAdd_Input_pojo deleteUserAddress(String addressId) {
		
		DeleteUserAdd_Input_pojo deleteUserAdd_Input_pojo=new DeleteUserAdd_Input_pojo(addressId);

		return deleteUserAdd_Input_pojo;
	}
	
	
}
