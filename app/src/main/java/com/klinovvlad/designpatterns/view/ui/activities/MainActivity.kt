package com.klinovvlad.designpatterns.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.klinovvlad.designpatterns.R
import com.klinovvlad.designpatterns.databinding.ActivityMainBinding
import com.klinovvlad.designpatterns.model.decorators.Borsch
import com.klinovvlad.designpatterns.model.decorators.Chicken
import com.klinovvlad.designpatterns.model.decorators.SourCream
import com.klinovvlad.designpatterns.view.adapters.ExampleAdapter
import com.klinovvlad.designpatterns.viewmodel.ExampleViewModel
import com.klinovvlad.designpatterns.viewmodel.ExampleViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: ExampleViewModel by lazy {
        ViewModelProvider(
            viewModelStore,
            ExampleViewModelFactory()
        ).get(ExampleViewModel::class.java)
    }
    private val exampleAdapter: ExampleAdapter by lazy {
        ExampleAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataToRecyclerView()

        builderExampleUsage()

        factoryExampleUsage()

        decoratorExampleUsage()
    }

    private fun dataToRecyclerView() {
        viewModel.getData()
        binding.exampleRecycMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = exampleAdapter
        }
        viewModel.exampleLiveData.observe(this) {
            exampleAdapter.submitList(it)
        }
    }

    private fun builderExampleUsage() {
        val exampleBuilderClass = viewModel.exampleBuilderClass
        binding.exampleBuilderMain.text = this.getString(
            R.string.example_builder_text,
            exampleBuilderClass.firstString,
            exampleBuilderClass.secondString,
            exampleBuilderClass.thirdString
        )
    }

    private fun factoryExampleUsage() {
        val exampleFactory = viewModel.exampleFactory
        binding.exampleFactoryMain.text = exampleFactory
    }

    private fun decoratorExampleUsage() {
        val borschWithChicken = Chicken(SourCream(Borsch())).getFood()
        binding.exampleDecoratorMain.text = borschWithChicken
    }

}