package is.tru.truin;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class AlmanakFragment extends Fragment implements OnClickListener {
	
	Button Salmabok;
	
	public AlmanakFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_almanak, container, false);
        
        Button Salmabok = (Button) rootView.findViewById(R.id.Salmabok);
        Salmabok.setOnClickListener(this); 
         
        return rootView;
    }

	@Override
	public void onClick(View v) {
		Fragment newFragment = new SalmabokFragment(); 
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();

	    transaction.replace(R.id.frame_container, newFragment);
        transaction.addToBackStack(null);

        transaction.commit(); 
		
	}
}
