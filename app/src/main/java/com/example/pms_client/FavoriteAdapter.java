package com.example.pms_client;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;

public class FavoriteAdapter extends BaseAdapter {

    private final Context context;
    private final int layoutId;
    private final FavoriteListItem[] favoriteList;

    public FavoriteAdapter(Context context, int layoutId, FavoriteListItem[] favoriteList) {

        this.context = context;
        this.layoutId = layoutId;
        this.favoriteList = favoriteList;
    }

    @Override
    public int getCount() {
        return favoriteList.length;
    }

    @Override
    public Object getItem(int i) {
        return favoriteList[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint({"SetTextI18n", "ViewHolder"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View lineItem;
        LayoutInflater layout = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        lineItem = layout.inflate(layoutId, null);
        boolean lineItemSelected = false;

        TextView nickName = (TextView)lineItem.findViewById(R.id.favorite_avatar_nickname);
        TextView name = (TextView)lineItem.findViewById(R.id.favorite_item_name);
        TextView phone = (TextView)lineItem.findViewById(R.id.favorite_item_phone);
        LinearLayout avatar = (LinearLayout)lineItem.findViewById(R.id.favorite_avatar_container);

        FavoriteListItem favoriteItem = favoriteList[i];
        nickName.setText(favoriteItem.getNickName());
        name.setText(favoriteItem.getName());
        phone.setText(favoriteItem.getPhoneTitle() + " " + favoriteItem.getPhone());

        Drawable drawableAvatar = ContextCompat.getDrawable(this.context, favoriteItem.getIconColor());
        avatar.setBackground(drawableAvatar);

        Drawable drawableNone = ContextCompat.getDrawable(this.context, R.drawable.none_background);
        Drawable drawableSelected = ContextCompat.getDrawable(this.context, R.drawable.rounded_background);

        lineItem.findViewById(R.id.favorite_item_info).setOnClickListener(v -> {

            if(lineItem.findViewById(R.id.contact_details).getVisibility() == View.GONE) {

                lineItem.findViewById(R.id.contact_details).setVisibility(View.VISIBLE);
                lineItem.findViewById(R.id.favorite_list_item).setBackground(drawableSelected);
            } else {

                lineItem.findViewById(R.id.contact_details).setVisibility(View.GONE);
                lineItem.findViewById(R.id.favorite_list_item).setBackground(drawableNone);
            }
        });

        lineItem.findViewById(R.id.favorite_sms).setOnClickListener(v -> {

//            Intent intentSms = new Intent(Intent.ACTION_VIEW);
//            intentSms.setData(Uri.parse("sms:" + favoriteItem.getPhone()));
//            context.startActivity(intentSms);
            Toast.makeText(context, favoriteItem.getPhone(), Toast.LENGTH_SHORT).show();
        });

        lineItem.findViewById(R.id.favorite_log).setOnClickListener(v -> {

            Toast.makeText(context, favoriteItem.getPhone(), Toast.LENGTH_SHORT).show();
//            Intent intentLog = new Intent(Intent.ACTION_VIEW);
//            Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(favoriteItem.getPhone()));
//            intentLog.setData(uri);
//            context.startActivity(intentLog);
        });

        lineItem.findViewById(R.id.favorite_item_info).setOnClickListener(v -> {

            Toast.makeText(context, favoriteItem.getPhone(), Toast.LENGTH_SHORT).show();
//            Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(favoriteItem.getPhone()));
//            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//            context.startActivity(intent);
        });

        return lineItem;
    }
}
