package is.tru.truin;

import java.util.Random;
import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class BaenastundFragment extends Fragment 
{
    Context context;
    TextView mannak;
    ViewPager pager;
	TruinPagerAdapter mPagerAdapter;
    
	public BaenastundFragment(){}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_baenastund, container, false);
       
        mannak = (TextView) rootView.findViewById(R.id.Mannakorn);
        context = getActivity();
        String[] Mannakorn = context.getResources().getStringArray(R.array.mannakorn);
        String randomMannakorn = Mannakorn[new Random().nextInt(Mannakorn.length)];
        
        pager = (ViewPager) rootView.findViewById(R.id.viewpager);
        
        mannak.setText(randomMannakorn);

        return rootView;
    }
	
	
}

