package is.tru.truin;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class BaenastundBlessunFragment extends Fragment implements OnClickListener {
	
	public BaenastundBlessunFragment(){}
	
	Button button;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_baenastund_blessun, container, false);
        
        Button button = (Button) rootView.findViewById(R.id.button);
        button.setOnClickListener(this);
         
        return rootView;
    }

	@Override
	public void onClick(View v) {
		//BaenastundFragment newFragment = new BaenastundFragment();
		//FragmentManager fragmentManager = getFragmentManager();
       /* FragmentTransaction transaction = getActivity().getFragmentManager.beginTransaction();

		transaction.replace(R.id.frame_container, newFragment);
        transaction.commit(); */
		Intent i = new Intent(getActivity(), BaenastundFragment.class);
		startActivity(i);
		
	}
}
