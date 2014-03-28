package is.tru.truin;



import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class AlmanakFragment extends FragmentActivity implements OnClickListener {

Button Salmabok;

public AlmanakFragment(){}

Spinner ar;
Spinner manudur;
Spinner dagur;

ArrayAdapter<String> aradapter;
ArrayAdapter<String> manuduradapter;
ArrayAdapter<CharSequence> daguradapter;


String ar_selected = "2005";
String manudur_selected = "jan�ar";
String dagur_selected = "1";

String [] arValues;
String [] manudurValues;
String [] dagurValues;

public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_almanak, container, false);
        
        setSpinnerContent(rootView);
        
        Button Salmabok = (Button) rootView.findViewById(R.id.Salmabok);
        Salmabok.setOnClickListener(new View.OnClickListener() {
        
            @Override
            public void onClick(View v) {
             SalmabokFragment newFragment = new SalmabokFragment();
                android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
         transaction.replace(R.id.frame_container, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        
        Button VeljaDag = (Button) rootView.findViewById(R.id.btnVeljaDag);
        VeljaDag.setOnClickListener(new View.OnClickListener() {
        
            @Override
            public void onClick(View v) {
             DagurValinnFragment newFragment = new DagurValinnFragment();
                android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
         transaction.replace(R.id.frame_container, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        
        return rootView;
    }

private void setSpinnerContent( View view )
{
	String [] arValues = {"2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", };
	String [] manudurValues = {"jan�ar", "febr�ar", "mars", "apr�l", "ma�", "j�n�", "j�l�", "�g�st", "september", "okt�ber", "n�vember","desember", };
	String [] dagurValues = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31",};
	        
	ar = (Spinner)view.findViewById(R.id.ar);
	        aradapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arValues);
	        ar.setAdapter( aradapter );
	        ar.setOnItemSelectedListener(new MyOnItemSelectedListener());
	         
	        manudur = (Spinner)view.findViewById(R.id.manudur);
	        manuduradapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, manudurValues);
	        manudur.setAdapter( manuduradapter );
	        manudur.setOnItemSelectedListener(new MyOnItemSelectedListener());
	        
	        dagur = (Spinner)view.findViewById(R.id.dagur);
	        daguradapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, dagurValues);
	        dagur.setAdapter( daguradapter );
	        dagur.setOnItemSelectedListener(new MyOnItemSelectedListener());
	        

}

@Override
public void onClick(View v) {
// TODO Auto-generated method stub

}

public class MyOnItemSelectedListener implements OnItemSelectedListener{


public void onItemSelected(AdapterView<?> parent, View v, int pos,long id) {

	if (manudur.getSelectedItem().equals("apr�l") || manudur.getSelectedItem().equals("j�n�") || manudur.getSelectedItem().equals("september") || manudur.getSelectedItem().equals("n�vember")) {
		daguradapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.dagarValuesStuttur,android.R.layout.simple_spinner_item);
		daguradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		dagur.setAdapter(daguradapter);	
	}
	else if (manudur.getSelectedItem().equals("febr�ar") && (ar.getSelectedItem().equals("2012") || ar.getSelectedItem().equals("2008") || ar.getSelectedItem().equals("2004"))) {
		daguradapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.dagarValuesFebHlaup,android.R.layout.simple_spinner_item);
		daguradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		dagur.setAdapter(daguradapter);
	}
	else if (manudur.getSelectedItem().equals("febr�ar") && (!ar.getSelectedItem().equals("2012") && !ar.getSelectedItem().equals("2008") && !ar.getSelectedItem().equals("2004"))) {
		daguradapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.dagarValuesFeb,android.R.layout.simple_spinner_item);
		daguradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		dagur.setAdapter(daguradapter);
	}
	else {
		daguradapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.dagarValues,android.R.layout.simple_spinner_item);
		daguradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		dagur.setAdapter(daguradapter);
	}

}



public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub

}

}

}