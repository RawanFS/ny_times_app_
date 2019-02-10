package com.example.rawanalsh.warba_test_v0;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;

import java.util.List;

public class NewsListAdapter extends ArrayAdapter<New> {
    private static final String TAG = "NewsListAdapter";
    private Context mContext;
    int mResource;




    public NewsListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<New> objects ) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;


    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //setup the image loader
        setupImageLoader();

        //get the news info
        String title = getItem(position).getTitle();
        String author = getItem(position).getAuthor();
        String date = getItem(position).getDate();
        String imgUrl = getItem(position).getImgUrl();

        //create the news object with the news info
        New new_ = new New(title, author, date, imgUrl);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView= inflater.inflate(mResource, parent, false);

        TextView tvTitle =  (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvAuthor =  (TextView) convertView.findViewById(R.id.tvAuthor);
        TextView tvDate =  (TextView) convertView.findViewById(R.id.tvDate);
        ImageView image = (ImageView) convertView.findViewById(R.id.image);

        tvTitle.setText(title);
        tvAuthor.setText(author);
        tvDate.setText(date);


        ImageLoader imageLoader = ImageLoader.getInstance();

        int defaultImage =  mContext.getResources().getIdentifier("@drawable/image_failed", null, mContext.getPackageName());
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .showImageOnLoading(defaultImage).build();
        imageLoader.displayImage(imgUrl, image);


        return convertView;
    }
    private void setupImageLoader (){
        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                mContext)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
    }
}
