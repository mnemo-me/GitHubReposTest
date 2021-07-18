package com.example.githubrepostest.ui.flow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.githubrepostest.databinding.FragmentFlowBinding
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class FlowFragment : MvpAppCompatFragment(), FlowView {

    @InjectPresenter
    lateinit var presenter: FlowPresenter

    private lateinit var binding: FragmentFlowBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{

        binding = FragmentFlowBinding.inflate(inflater, container, false)

        return binding.root
    }

}