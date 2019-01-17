package one.jamaa.appjamaa.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

import one.jamaa.appjamaa.R;
import one.jamaa.appjamaa.information.Users;

public class UsersAdapter extends FirestoreRecyclerAdapter<Users, UsersAdapter.MyViewHolder> {

private static final String TAG = "ProjectsAdapter";
private OnItemClickListener listener;

public UsersAdapter(FirestoreRecyclerOptions<Users> options){
        super(options);
        Log.d(TAG, "ProjectsAdapter: ");
        }

@NonNull
@Override
public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card, parent, false);
        return new MyViewHolder(view);
        }

@Override
protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull Users model) {
        Log.d(TAG, "onBindViewHolder: ");
        holder.numberProjects.setText(model.getParticipated());
        holder.investedIn.setText(model.getInvested());
        }

public void deleteItem(int position){
        getSnapshots().getSnapshot(position).getReference().delete();
        }


class MyViewHolder extends RecyclerView.ViewHolder{

    TextView numberProjects, investedIn, projectLength;

    MyViewHolder(@NonNull View itemView) {
        super(itemView);
        numberProjects = itemView.findViewById(R.id.number_projects);
        investedIn = itemView.findViewById(R.id.invested_in);
        projectLength = itemView.findViewById(R.id.project_length);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null){
                    listener.onItemClick(getSnapshots().getSnapshot(position), position);
                }
            }
        });
    }
}

public interface OnItemClickListener{
    void onItemClick(DocumentSnapshot snapshot, int position);
}

    public void setOnItemClickListener(UsersAdapter.OnItemClickListener listener){
        this.listener = listener;
    }
}
