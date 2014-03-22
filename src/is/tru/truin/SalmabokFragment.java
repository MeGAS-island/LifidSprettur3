package is.tru.truin;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.mail.Message;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SalmabokFragment extends Fragment {
	
	TextView salmur;
	JSONObject jsonObject;
	String salmurText;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_salmabok, container, false); 
        
        new getJSONTask().execute();
		
		salmur = (TextView)rootView.findViewById(R.id.salmur);
		salmur.setText(salmurText);
		
		return rootView;
    }
    
    private class getJSONTask extends  AsyncTask<Void, Void, Void>{
    	
    	ProgressDialog pDialog;
    	
    	protected Void doInBackground(Void...params) {
	    	try {
				DefaultHttpClient defaultClient = new DefaultHttpClient();
				HttpGet httpGetRequest = new HttpGet("http://www2.tru.is/app/json.php?s=salmur&id=50");
				HttpResponse httpResponse = defaultClient.execute(httpGetRequest);
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), "utf-8"));
				String json = reader.readLine();
				
				jsonObject = new JSONObject(json);
				
				salmurText = (String) jsonObject.get("texti");
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return null;
    	}
		@Override
		protected void onPreExecute(){
			super.onPreExecute();
			CharSequence bidid = "Vinsamlega bíðið";
			CharSequence sendi = "Sæki sálm"; 
			pDialog = ProgressDialog.show(getActivity(), bidid, sendi, true, false);
		}
		
		@Override
		protected void onPostExecute(Void aVoid){
			super.onPostExecute(aVoid);
			pDialog.dismiss();
		}

    }
}
