# Simulated Air Conditioner Test Tools

This repo contains tools to create a controller for an air conditioner that can be run using the smartthings **Classis** app.
And, it includes sample openHAB config files for an air conditioner.

This directory consists of:
1. The Simulated Air Conditioner device handler
2. A set of openHAB config files (.things, .items and .sitemap) for testing the Smartthings Air Conditioner cpabilities

## Simulated Air Conditioner Device Handler

This is a Smartthings "Device Handler" that can be used to control a "Virtual" Simulated Air Conditioner. This is useful for testing the openHAB Air Conditioner components.

To use this you will have to first create a virtual Device named simulated Air Conditioner.


### Installation
1. Locate SimulatedAirConditioner.groovy file.
2. Open it in an editor (Some program you can use to copy the contents to the clipboard)
3. Copy the contents to the clipboard
4. Using the Smartthings developers tools:
5. Select **My Device Handlers** 
6. Click on the **+ Create New Device Handler** near the top right
7. Click on the **From Code** tab
8. Paste the contents of the clipboard
9. Click on the **Create** button near the bottom left
10. Click on **Publish -> For Me**
11. The Device Handler is now ready

## openHAB config files

These three files are a set of openHAB config files for testing the Air Conditioner.

### Installation

Edit each of the config files (.things, .items, .sitmap) files on your openHAB server and add the appropriate contents from each of these files. Each of the files includes instructions about the changes needed to integrate with your openHAB config.
