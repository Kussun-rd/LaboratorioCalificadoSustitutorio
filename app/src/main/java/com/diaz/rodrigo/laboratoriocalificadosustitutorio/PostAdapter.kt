package com.diaz.rodrigo.laboratoriocalificadosustitutorio

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diaz.rodrigo.laboratoriocalificadosustitutorio.databinding.ItemPostBinding

class PostAdapter(private val context: Context, private val posts: List<Post>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.tvTitle.text = post.title
            binding.tvBody.text = post.body

            binding.root.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("smsto:+51925137361")
                    putExtra("sms_body", post.title)
                }
                context.startActivity(intent)
            }

            binding.root.setOnLongClickListener {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_EMAIL, arrayOf("victor.saico@tecsup.edu.pe"))
                    putExtra(Intent.EXTRA_SUBJECT, "Post Body")
                    putExtra(Intent.EXTRA_TEXT, post.body)
                }
                context.startActivity(Intent.createChooser(intent, "Send Email"))
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size
}
