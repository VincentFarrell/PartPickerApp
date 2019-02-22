package app.vfarrell.pcpartpickerapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import app.vfarrell.pcpartpickerapp.R;


public class MenuListAdapter extends BaseAdapter {

    Context context;
    private final String [] components;
    private final int [] images;

    public MenuListAdapter(Context context, String [] components, int [] images) {
        this.context = context;
        this.components = components;
        this.images = images;
    }

    @Override
    public int getCount() {
        return components.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;

        final View result;

        if(convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.menu_list_rows, parent, false);
            viewHolder.menuText = (TextView) convertView.findViewById(R.id.menuText);
            viewHolder.menuText2 = (TextView) convertView.findViewById(R.id.menuText2);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.imgIcon);

            result = convertView;

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.menuText.setText(components[position]);
        viewHolder.menuText2.setText("Tap to see all "+components[position]);
        viewHolder.icon.setImageResource(images[position]);

        return convertView;
    }

    private static class ViewHolder {

        TextView menuText;
        TextView menuText2;
        ImageView icon;
    }
}
