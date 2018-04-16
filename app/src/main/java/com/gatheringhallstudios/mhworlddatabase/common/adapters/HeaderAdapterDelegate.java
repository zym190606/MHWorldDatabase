package com.gatheringhallstudios.mhworlddatabase.common.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gatheringhallstudios.mhworlddatabase.R;
import com.gatheringhallstudios.mhworlddatabase.common.Consumer;
import com.gatheringhallstudios.mhworlddatabase.common.models.Header;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.List;

/**
 * Adapter delegate to handle displaying Header objects inside RecyclerViews.
 */
public class HeaderAdapterDelegate extends AdapterDelegate<List<Object>> {

    private Consumer<Object> onSelected;

    public HeaderAdapterDelegate(Consumer<Object> onSelected) {
        this.onSelected = onSelected;
    }

    @Override
    protected boolean isForViewType(@NonNull List<Object> items, int position) {
        return items.get(position) instanceof Header;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.listitem_section_header, parent, false);

        return new HeaderViewHolder(v);
    }

    @Override
    protected void onBindViewHolder(@NonNull List<Object> items,
                                    int position,
                                    @NonNull RecyclerView.ViewHolder holder,
                                    @NonNull List<Object> payloads) {
        Header header = (Header) items.get(position);

        HeaderViewHolder vh = (HeaderViewHolder) holder;

        vh.labelText.setText(header.text);

        holder.itemView.setOnClickListener((View v) -> onSelected.accept(items.get(position)));

    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView labelText;

        HeaderViewHolder(View itemView) {
            super(itemView);
            labelText = itemView.findViewById(R.id.label_text);
        }
    }
}
