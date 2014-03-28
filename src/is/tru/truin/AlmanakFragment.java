package is.tru.truin;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v4.app.Fragment;

public class AlmanakFragment extends FragmentActivity implements OnClickListener {
	
	Button Salmabok;
	
	public AlmanakFragment(){}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_almanak, container, false);
        
        Button Salmabok = (Button) rootView.findViewById(R.id.Salmabok);
        Salmabok.setOnClickListener(this); 
         
        return rootView;
    }

	@Override
	public void onClick(View v) {
		SalmabokFragment newFragment = new SalmabokFragment(); 
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();

	    transaction.replace(R.id.frame_container, newFragment);
        transaction.addToBackStack(null);

        transaction.commit(); 
		
	}
}
