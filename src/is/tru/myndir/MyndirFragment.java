package is.tru.myndir;


import com.androidquery.AQuery;

import is.tru.truin.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyndirFragment extends Fragment {
	
	private AQuery aq;
	
	public MyndirFragment(){}
	
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myndir_grid,container,false);
        
        aq = new AQuery(getActivity(), view);
        aq.id(R.id.image1).image("http://blikar.is/images/sized/images/uploads/leikmenn/ElfarFreyrHelgasonSep2013-197x263.jpg");
        aq.id(R.id.image2).image("http://blikar.is/images/sized/images/uploads/leikmenn/ElfarFreyrHelgasonSep2013-197x263.jpg");

        
        String[] imageUrl = Constants.IMAGES;     
        //for(int i = 0; i < imageUrl.length; i++) {
        //	aq.id(R.id.image).image("http://www.vikispot.com/z/images/vikispot/android-w.png");
        //}
        
        return view;
    }
	
}