package is.tru.truin;


import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class AlmanakFragment extends Fragment implements OnClickListener {
	
	Button Salmabok;
		
	public AlmanakFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_almanak, container, false);
        
        setSpinnerContent(rootView);
        
        Button Salmabok = (Button) rootView.findViewById(R.id.Salmabok);
        Salmabok.setOnClickListener(new View.OnClickListener() {
        	
            @Override
            public void onClick(View v) {
            	Fragment newFragment = new SalmabokFragment();
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
            	Fragment newFragment = new DagurValinnFragment();
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
        Spinner ar = (Spinner)view.findViewById(R.id.ar); 
        String [] arValues = {"2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", };
        ArrayAdapter<String> aradapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, arValues);
        ar.setAdapter( aradapter );
        
        Spinner manudur = (Spinner)view.findViewById(R.id.manudur);
        String [] manudurValues = {"janúar", "febrúar", "mars", "apríl", "maí", "júní", "júlí", "ágúst", "september", "október", "nóvember","desember", };
        ArrayAdapter<String> manuduradapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, manudurValues);
        manudur.setAdapter( manuduradapter );
        
        Spinner dagur = (Spinner)view.findViewById(R.id.dagur);
        String [] dagurValues = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31",};
        ArrayAdapter<String> daguradapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, dagurValues);
        dagur.setAdapter( daguradapter );
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	

}
