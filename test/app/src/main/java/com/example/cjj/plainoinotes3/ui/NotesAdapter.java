package com.example.cjj.plainoinotes3.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cjj.plainoinotes3.R;
import com.example.cjj.plainoinotes3.database.NoteEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/***
 * author：caijj1
 * time：2018/5/27
 * mail:caijj1@chanjet.com
 **/
public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private final List<NoteEntity> mNotes;
    private final Context mContext;

    public NotesAdapter(List<NoteEntity> mNotes, Context mContext) {
        this.mNotes = mNotes;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.note_list_item,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final NoteEntity note = mNotes.get(position);
        holder.mTextView.setText(note.getText());
    }

    @Override
    public int getItemCount() {
//        return 0;
        return mNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.note_text)
        TextView mTextView;
        public ViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }
}
