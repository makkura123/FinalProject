package com.example.addr_book;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity{
	
	 public void onCreate(Bundle savedInstanceState) {	    	
	    	super.onCreate(savedInstanceState);
	        setContentView(R.layout.login);
	 }
	 
	 public void btnLogin(View v) {
		    //Make sure the user's logged in
		    TextView _name = (TextView)this.findViewById(R.id.txtuName);
		    TextView _pwd = (TextView)this.findViewById(R.id.txtPwd);
		    if (!_name.getText().toString().equals("Neele")) {    
		    	Toast.makeText(this, "Wrong Username", Toast.LENGTH_LONG).show();
		    	return;
		    	}  
		    
		    if (!_pwd.getText().toString().equals("Test")) {    
			    Toast.makeText(this, "Wrong Password", Toast.LENGTH_LONG).show();
			    return;
			    }
		    
		    Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			
	 }
	 
	 public void btnUser(View v) {
		 Toast.makeText(this, "Not available yet", Toast.LENGTH_LONG).show();
		 return;
		}
}
