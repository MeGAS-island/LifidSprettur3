package is.tru.truin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class BaenastundKyrrdFragment extends Fragment implements OnClickListener {
	
    Button btnHaldaAfram02;
	
	public BaenastundKyrrdFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_baenastund_kyrrd, container, false);
        
        Button btnHaldaAfram02 = (Button) rootView.findViewById(R.id.button_002);
        btnHaldaAfram02.setOnClickListener(this);       
         
        return rootView;
    }
	
    @Override
    public void onClick(View v) {
/*
        BaenastundSignaFragment newFragment = new BaenastundSignaFragment(); 
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.replace(R.id.frame_container, newFragment);
        transaction.addToBackStack(null);

        transaction.commit(); */

    }
    
    public static Fragment newInstance(String string) {
		BaenastundKyrrdFragment f = new BaenastundKyrrdFragment();
		return f;
	}
  
}
