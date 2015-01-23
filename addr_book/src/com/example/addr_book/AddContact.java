package com.example.addr_book;

import android.os.Bundle;
import android.provider.Contacts;
import android.provider.Contacts.Intents;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.app.Fragment;
import android.content.ContentResolver;  
import android.content.ContentUris;  
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class AddContact extends MainActivity {
	
	 public void onCreate(Bundle savedInstanceState) {	    	
	    	super.onCreate(savedInstanceState);
	        setContentView(R.layout.add_contact);
	 }
	 
	 @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Handle action bar item clicks here. The action bar will
	        // automatically handle clicks on the Home/Up button, so long
	        // as you specify a parent activity in AndroidManifest.xml.
	        int id = item.getItemId();	        
	        return super.onOptionsItemSelected(item);
	    }
	 
	 @SuppressWarnings("deprecation")
	public void btnAdd (View v){
		TextView _name = (TextView)this.findViewById(R.id.txtName);
		TextView _phone = (TextView)this.findViewById(R.id.txtPhone);
		TextView _email = (TextView)this.findViewById(R.id.txtEmail);
		TextView _address = (TextView)this.findViewById(R.id.txtStreet);
		

		if (_name.getText().length() != 0 && _phone.getText().length() != 0){
		 Toast.makeText(this, "New Contact added",
                 Toast.LENGTH_LONG).show();

		
		 @SuppressWarnings("deprecation")
		Intent intent = new Intent(Intents.Insert.ACTION);
		// Sets the MIME type to match the Contacts Provider
		intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
		intent.putExtra(Intents.Insert.NAME, _name.getText());
		intent.putExtra(Intents.Insert.EMAIL, _email.getText());
		intent.putExtra(Intents.Insert.PHONE, _phone.getText());		
		intent.putExtra(Intents.Insert.POSTAL, _address.getText());

		intent.putExtra(Intents.Insert.PHONE_TYPE, Phone.TYPE_MOBILE);
		startActivity(intent);
		
		}
	 
	    else
		 Toast.makeText(this, "Enter name and e-mail",
                 Toast.LENGTH_LONG).show();

	 }
}
