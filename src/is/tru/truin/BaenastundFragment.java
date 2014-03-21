package is.tru.truin;


import java.util.Random;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class BaenastundFragment extends Fragment implements OnClickListener {
	
    Button btnHaldaAfram01;
    Context context;
    TextView mannak;
	
	public BaenastundFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_baenastund, container, false);
        
        Button btnHaldaAfram01 = (Button) rootView.findViewById(R.id.button_001);
        btnHaldaAfram01.setOnClickListener(this);  

        mannak = (TextView) rootView.findViewById(R.id.Mannakorn);
        context = getActivity();
        String[] Mannakorn = context.getResources().getStringArray(R.array.mannakorn);
        String randomMannakorn = Mannakorn[new Random().nextInt(Mannakorn.length)];
        
        mannak.setText(randomMannakorn);
        
        return rootView;
    }
	
    @Override
    public void onClick(View v) {

        Fragment newFragment = new BaenastundKyrrdFragment(); 
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.replace(R.id.frame_container, newFragment);
        transaction.addToBackStack(null);

        transaction.commit(); 

    }
  
}
