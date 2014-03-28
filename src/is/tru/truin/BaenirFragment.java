package is.tru.truin;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class BaenirFragment extends Fragment implements OnClickListener {
	
	public BaenirFragment(){}
	
	Button fyrirbaenaefni;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_baenir, container, false);
         
        Button fyrirbaenaefni = (Button) rootView.findViewById(R.id.fyrirbaenaefni);
        fyrirbaenaefni.setOnClickListener(this);       
         
        return rootView;
    }
	
	public void onClick(View v){
		
		Fragment newFragment = new FyrirbaenaefniFragment(); 
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();

	    transaction.replace(R.id.frame_container, newFragment);
        transaction.addToBackStack(null);

        transaction.commit(); 

		
	}
}
