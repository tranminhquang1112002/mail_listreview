package com.example.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import io.bloco.faker.components.Date;

public class MailAdapter extends BaseAdapter {
    List<Mail> mails;

    public MailAdapter(List<Mail> mails) {
        this.mails = mails;
    }

    @Override
    public int getCount() {
        return mails.size();
    }

    @Override
    public Object getItem(int position) {
        return mails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_layout, null);
            viewHolder = new ViewHolder();

            viewHolder.imageAvatar = convertView.findViewById(R.id.avatar);
            viewHolder.mailSender = convertView.findViewById(R.id.mail_sender);
            viewHolder.mailTitle = convertView.findViewById(R.id.mail_title);
            viewHolder.mailContent = convertView.findViewById(R.id.mail_content);
            viewHolder.checkBox = convertView.findViewById(R.id.checkbox);
            viewHolder.arrivedAt = convertView.findViewById(R.id.mail_arrived_at);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }



        Mail mail = mails.get(position);

        viewHolder.imageAvatar.setText(mail.getSender().charAt(0) + "");
        viewHolder.mailSender.setText(mail.getSender());
        viewHolder.mailTitle.setText(mail.getTitle());
        viewHolder.mailContent.setText(mail.getContent());
        viewHolder.checkBox.setChecked(mail.isStar());
        viewHolder.arrivedAt.setText(mail.getArrivedAt());
        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mail.setStar(viewHolder.checkBox.isChecked());
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    private class ViewHolder{
        public TextView imageAvatar;
        public TextView mailSender;
        public TextView mailTitle;
        public TextView mailContent;
        public CheckBox checkBox;
        private TextView arrivedAt;
    }

}
