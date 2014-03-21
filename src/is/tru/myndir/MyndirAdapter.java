package is.tru.myndir;

import is.tru.myndir.Constants;
import is.tru.truin.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyndirAdapter extends BaseAdapter {
private Context mContext;
String[] imageUrls;

public  MyndirAdapter(Context c) {
    mContext = c;
}

public int getCount() {
    return mThumbIds.length;
}

public Object getItem(int position) {
    return null;
}

public long getItemId(int position) {
    return 0;
}

 public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
 
 

private Integer[] mThumbIds = {
        R.drawable.ic_bible_black, R.drawable.ic_candle,
        R.drawable.ic_pages, R.drawable.ic_candle,
        R.drawable.ic_bible_black, R.drawable.ic_praying,
        R.drawable.ic_pages, R.drawable.ic_candle,
        R.drawable.ic_bible_black, R.drawable.ic_pages,
        R.drawable.ic_praying, R.drawable.ic_candle,
        R.drawable.ic_bible_black, R.drawable.ic_praying,
        R.drawable.ic_pages, R.drawable.ic_candle,
        R.drawable.ic_bible_black, R.drawable.ic_praying,
        R.drawable.ic_pages, R.drawable.ic_candle,
        R.drawable.ic_bible_black, R.drawable.ic_candle
};


}


