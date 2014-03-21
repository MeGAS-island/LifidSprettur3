package is.tru.myndir;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyndirFragment extends Fragment {
	
	public MyndirFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
		Intent intent = new Intent(getActivity(), ImageGridActivity.class);
		startActivity(intent);
         
		return null;
    }
	
}