package com.hephzisoft.boomplay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;



import java.util.ArrayList;

public class AlbumAdapter extends ArrayAdapter<Album> {
    Context context;

    public AlbumAdapter(@NonNull Context context, ArrayList<Album> albumArrayAdapter) {
        super(context, 0, albumArrayAdapter);
        this.context = context;
    }

    public View getView(int position, @Deprecated View convertView, @NonNull ViewGroup parent) {
        View albumView = convertView;
        if (albumView == null) {

            albumView = LayoutInflater.from(getContext()).inflate(R.layout.music_grid_layout, parent, false);
        }
        Album album  = getItem(position);

        TextView albumName =  albumView.findViewById(R.id.list_name);
        ImageView albumImage = albumView.findViewById(R.id.album_image);

        albumName.setText(album.getAlbum_name());
        albumImage.setImageResource(album.getAlbum_image());

        return albumView;
    }
}
