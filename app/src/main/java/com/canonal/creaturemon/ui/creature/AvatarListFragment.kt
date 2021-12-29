package com.canonal.creaturemon.ui.creature

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.canonal.creaturemon.data.remote.RetrofitClient
import com.canonal.creaturemon.data.remote.RickAndMortyApi
import com.canonal.creaturemon.data.remote.response.Character
import com.canonal.creaturemon.databinding.FragmentAvatarListBinding
import com.canonal.creaturemon.ui.adapter.AvatarAdapter
import com.canonal.creaturemon.ui.util.recyclerViewUtil.RecyclerViewUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AvatarListFragment : Fragment() {

    private lateinit var binding: FragmentAvatarListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAvatarListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rvAvatar = binding.rvAvatarList
        val retrofit = RetrofitClient.getRetrofitInstance()
        val rickAndMortyApi = retrofit.create(RickAndMortyApi::class.java)
        val multipleCharacters = rickAndMortyApi.getMultipleCharacters(
            1, 183, 2, 3, 5,
            8, 20, 15, 17, 124,
            254, 69, 99, 100, 11
        )

        multipleCharacters.enqueue(object : Callback<List<Character>> {
            override fun onResponse(
                call: Call<List<Character>>,
                response: Response<List<Character>>
            ) {
                val multipleCharactersResponse = response.body() as List<Character>
                val avatarAdapter = AvatarAdapter(multipleCharactersResponse)
                RecyclerViewUtils.initializeRecyclerView(
                    rvAvatar,
                    avatarAdapter,
                    GridLayoutManager(view.context, 3),
                    false
                )
//                rvAvatar.adapter = avatarAdapter
//                rvAvatar.layoutManager = GridLayoutManager(view.context, 3)
//                rvAvatar.setHasFixedSize(true)
            }

            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                Log.e("RETROFIT", "onFailure: FAIL ")
            }

        })
    }
}


