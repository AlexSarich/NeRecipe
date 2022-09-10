package ru.netology.nerecipe.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import ru.netology.nerecipe.databinding.FragmentFilterBinding
import ru.netology.nerecipe.viewModel.RecipeViewModel

class RecipeFilterFragment : Fragment() {
    private val viewModel by activityViewModels<RecipeViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentFilterBinding.inflate(layoutInflater, container, false).also { binding ->

        binding.buttonApply.setOnClickListener {
            onApplyButtonClicked(binding)
        }
        if (!viewModel.toggleCheckEuropean)
            binding.checkBoxEuropean.isChecked = false
        if (!viewModel.toggleCheckAsian)
            binding.checkBoxAsian.isChecked = false
        if (!viewModel.toggleCheckPanasian)
            binding.checkBoxPanasian.isChecked = false
        if (!viewModel.toggleCheckEastern)
            binding.checkBoxEastern.isChecked = false
        if (!viewModel.toggleCheckAmerican)
            binding.checkBoxAmerican.isChecked = false
        if (!viewModel.toggleCheckRussian)
            binding.checkBoxRussian.isChecked = false
        if (!viewModel.toggleCheckMediterranean)
            binding.checkBoxMediterranean.isChecked = false
    }.root

    private fun onApplyButtonClicked(binding: FragmentFilterBinding) {
        var checkedCount = 0
        val numberOfFilters = 7

        if (!binding.checkBoxEuropean.isChecked) {
            ++checkedCount
            viewModel.showEuropean("European")
        } else viewModel.toggleCheckEuropean
        if (!binding.checkBoxAsian.isChecked) {
            ++checkedCount
            viewModel.showAsian("Asian")
        } else viewModel.toggleCheckAsian
        if (!binding.checkBoxPanasian.isChecked) {
            ++checkedCount
            viewModel.showPanasian("Panasian")
        } else viewModel.toggleCheckPanasian
        if (!binding.checkBoxEastern.isChecked) {
            ++checkedCount
            viewModel.showEastern("Eastern")
        } else viewModel.toggleCheckEastern
        if (!binding.checkBoxAmerican.isChecked) {
            ++checkedCount
            viewModel.showAmerican("American")
        } else viewModel.toggleCheckAmerican
        if (!binding.checkBoxRussian.isChecked) {
            ++checkedCount
            viewModel.showRussian("Russian")
        } else viewModel.toggleCheckRussian
        if (!binding.checkBoxMediterranean.isChecked) {
            ++checkedCount
            viewModel.showMediterranean( "Mediterranean")
        } else viewModel.toggleCheckMediterranean

        if (checkedCount == numberOfFilters) {
            Toast.makeText(activity, "You cannot disable all filters", Toast.LENGTH_LONG).show()
            return
        } else findNavController().popBackStack()
    }

}
