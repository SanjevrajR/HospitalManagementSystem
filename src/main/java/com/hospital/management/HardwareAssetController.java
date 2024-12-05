package com.hospital.management;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/assets")
public class HardwareAssetController {

    @Autowired
    private HardwareAssetRepository hardwareAssetRepository;

    @GetMapping
    public String listAssets(Model model) {
        model.addAttribute("assets", hardwareAssetRepository.findAll());
        return "hardware-assets";
    }

    @GetMapping("/add")
    public String addAssetForm(Model model) {
        model.addAttribute("asset", new HardwareAsset());
        return "add-asset";
    }

    @PostMapping("/save")
    public String saveAsset(@ModelAttribute HardwareAsset asset) {
        hardwareAssetRepository.save(asset);
        return "redirect:/assets";
    }

    @GetMapping("/edit/{id}")
    public String editAssetForm(@PathVariable int id, Model model) {
        model.addAttribute("asset", hardwareAssetRepository.findById(id).orElse(null));
        return "edit-asset";
    }

    @PostMapping("/update")
    public String updateAsset(@ModelAttribute HardwareAsset asset) {
        hardwareAssetRepository.save(asset);
        return "redirect:/assets";
    }

    @GetMapping("/delete/{id}")
    public String deleteAsset(@PathVariable int id) {
        hardwareAssetRepository.deleteById(id);
        return "redirect:/assets";
    }
}

