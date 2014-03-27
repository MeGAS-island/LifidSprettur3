package is.tru.truin;

import org.json.JSONObject;

import util.JSONParser;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DagurValinnFragment extends Fragment {
	
	TextView lestur;
	JSONObject jsonObject;
	String lesturText;
	View rootView;
		

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        rootView = inflater.inflate(R.layout.fragment_dagur_valinn, container, false); 

        new getJSONTask().execute();
		
		return rootView;
    }
    
    private class getJSONTask extends  AsyncTask<Void, Void, Void>{
    	
    	ProgressDialog pDialog;
    	
    	protected Void doInBackground(Void...params) {
	    	try {
	    		JSONParser jParser = new JSONParser();
				jsonObject = jParser.getJSONFromUrl("http://www2.tru.is/app/json.php?s=dagur&id=360&y=2012");
				
				lesturText = jsonObject.getString("lestur_txt");

				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return null;
    	}
		@Override
		protected void onPreExecute(){
			super.onPreExecute();
			
			lestur = (TextView)rootView.findViewById(R.id.dagurValinn);
			CharSequence bidid = "Vinsamlega bíðið";
			CharSequence sendi = "Sæki Lestur"; 
			pDialog = ProgressDialog.show(getActivity(), bidid, sendi, true, false);
		}
		
		@Override
		protected void onPostExecute(Void aVoid){
			super.onPostExecute(aVoid);
			lestur.setText(lesturText);
			pDialog.dismiss();
		}

    }
}
