package com.sejin.esc_contact_2017.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.sejin.esc_contact_2017.DetailActivity;
import com.sejin.esc_contact_2017.R;
import com.sejin.esc_contact_2017.data.ContactData;


import java.util.ArrayList;

/**
 * Created by sejin on 2017. 7. 19..
 */

public class ContactRcvAdapter extends RecyclerView.Adapter<ContactRcvAdapter.ViewHolder>{

    /***********************************************/
    /** TODO declare view components in item view **/
    /***********************************************/
    private ArrayList<ContactData> contactList;
    private Context context;

    public ContactRcvAdapter(ArrayList<ContactData> contactList, Context context) {
        this.contactList = contactList;
        this.context = context;
    }

    /** 아이템으로 구현될 xml 파일을 inflate하여 view라는 변수에 넣고,
     * view는 다시 ViewHolder의 생성자로 들어가서 ViewHolder객체를 생성합니다
     * 그리고 해당 객체인 viewHolder를 리턴합니다
     * 리턴된 객체는 onBindViewHolder() 메소드로 들어가게 됩니다
     * */

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // LayoutInflater?
        // Class required to make View instance as layout defined in xml
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    /** 아이템뷰들을 Bind합니다(묶습니다).
     * 다시 말하면 각각의 아이템뷰를 리스트처럼 만들어주고, 각 아이템뷰마다 리스트에서의 포지션이 알아서 제공됩니다. (첫번째 :0)
     * */

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final ContactData contactData= contactList.get(position);

        holder.tvName.setText(contactData.getName());
        holder.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + contactData.getPhoneNum()));
                context.startActivity(callIntent);
            }
        });
        holder.btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent msgIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + contactData.getPhoneNum()));
                context.startActivity(msgIntent);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, DetailActivity.class);
                /** 인텐트 이용 정보 전달.*/
                intent.putExtra("position",position);
                context.startActivity(intent);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(context);

                dialog.setMessage("정말로 삭제하시겠습니까?");
                dialog.setCancelable(true);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        removeItemView(position);


                    }
                });

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                dialog.show();


                return false;
            }
        });

    }

    private void removeItemView(int position) {
        contactList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,contactList.size());

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageButton btnCall,btnMsg;
        TextView tvName;

        /**************************************************/
        /** TODO initialize view components in item view **/
        /**************************************************/
        public ViewHolder(View itemView) {
            super(itemView);
            btnCall=(ImageButton)itemView.findViewById(R.id.contact_call_btn);
            btnMsg=(ImageButton)itemView.findViewById(R.id.contact_msg_btn);
            tvName=(TextView)itemView.findViewById(R.id.contact_name);
        }
    }
}
