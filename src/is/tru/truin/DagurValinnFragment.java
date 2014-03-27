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
	
	TextView Tvtitill;
	TextView Tvlestur;
	TextView TvlesturTxt;
	TextView Tvlestur2;
	TextView Tvlestur2Txt;
	TextView TvSalmurNr;
	TextView TvSalmurText;
	TextView TvBaenText;
	TextView TvminnisversTxt;
	JSONObject jsonObject;
	String titill;
	String lestur;
	String lesturText;
	String lestur2;
	String lestur2Text;
	String SalmurNr;
	String SalmurText;
	String BaenText;
	String MinnisversText;
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
				
				titill = jsonObject.getString("titill");
				lestur = jsonObject.getString("lestur");
				lesturText = jsonObject.getString("lestur_txt");
				lestur2 = jsonObject.getString("lestur2");
				lestur2Text = jsonObject.getString("lestur2_txt");
				SalmurNr = jsonObject.getString("salmur_numer");
				SalmurText = jsonObject.getString("salmur_txt");
				BaenText = jsonObject.getString("baen_txt");
				MinnisversText = jsonObject.getString("minnisvers_txt");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return null;
    	}
		@Override
		protected void onPreExecute(){
			super.onPreExecute();
						
			Tvtitill = (TextView)rootView.findViewById(R.id.TvTitill);
			Tvlestur = (TextView)rootView.findViewById(R.id.TvLestur);
			TvlesturTxt = (TextView)rootView.findViewById(R.id.TvLesturTxt);
			Tvlestur2 = (TextView)rootView.findViewById(R.id.TvLestur2);
			Tvlestur2Txt = (TextView)rootView.findViewById(R.id.TvLestur2Txt);
			TvSalmurNr = (TextView)rootView.findViewById(R.id.TvSalmurNr);
			TvSalmurText = (TextView)rootView.findViewById(R.id.TvSalmurText);
			TvBaenText = (TextView)rootView.findViewById(R.id.TvBaenText);
			TvminnisversTxt = (TextView)rootView.findViewById(R.id.TvMinnisversTxt);
			
			
			
			CharSequence bidid = "Vinsamlega bíðið";
			CharSequence sendi = "Sæki Lestur"; 
			pDialog = ProgressDialog.show(getActivity(), bidid, sendi, true, false);
		}
		
		@Override
		protected void onPostExecute(Void aVoid){
			super.onPostExecute(aVoid);
			Tvtitill.setText(titill);
			Tvlestur.setText(lestur);
			TvlesturTxt.setText(lesturText);
			Tvlestur2.setText(lestur2);
			Tvlestur2Txt.setText(lestur2Text);
			TvSalmurNr.setText(SalmurNr);
			TvSalmurText.setText(SalmurText);
			TvBaenText.setText(BaenText);
			TvminnisversTxt.setText(MinnisversText);
			pDialog.dismiss();
		}

    }
}
