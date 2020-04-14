/**
 *  Simulated Air Conditioner Device Handler
 *  Bob Raker 4/9/2020
 *
 */
metadata {
	definition (name: "Simulated Air Conditioner", namespace: "bobrak", author: "Bob Raker") {
		capability "Switch"
        capability "Air Conditioner Mode"
        capability "Temperature Measurement"
        capability "Thermostat"
       
        // commands
        command "cool"
        command "dry"
        command "coolClean"
        command "auto"
        command "initialize"
        command "setCoolingSetpoint"
        
        attribute "version", "number"
	}

	simulator {
	}

	// No icons because so few work anymore
	tiles (scale: 2) {
    	// Line 1
		standardTile("initializeLabel", "", width: 6, height: 2) {
			state "initialize", label: "Click to set initial values", action: "initialize"
		}

    	// Line 2
		standardTile("initialize", "device.switch", width: 4, height: 2) {
			state "off", label: "Click Off to turn on"
			state "on", label: "Click On to turn off"
		}
		standardTile("switch", "device.switch", width: 2, height: 2, canChangeIcon: true) {
			state "off", label: "Off", action: "switch.on", backgroundColor: "#ffffff"
			state "on", label: "On", action: "switch.off", backgroundColor: "#00a0dc"
		}

    	// Line 3
		standardTile("A/C Mode", "device.airConditionerMode", width: 2, height: 2) {
			state("auto", label:"Auto", action:"cool", backgroundColor:"#ff4d4d")
			state("cool", label:"Cool", action:"dry", backgroundColor:"#00e64d")
			state("dry", label:"Dry", action:"coolClean", backgroundColor:"#cccccc")
			state("coolClean", label:"Cool clean", action:"auto", backgroundColor:"#adadad")
		}

        valueTile("airConditionerDisplayTile", "device.airConditionerMode", width: 2, height: 2) {
        	state "val", label:'A C Mode\n ${currentValue}', defaultState: true
        }
        
        valueTile("temperatureMeasurementTile", "temperature", width: 2, height: 2) {
        	state "val", label:'Temp\n ${currentValue}', defaultState: true
        }
        
    	// Line 4
        valueTile("thermostatCoolingSetpointTile", "device.coolingSetpoint", width: 2, height: 2) {
        	state "val", label:'Cool setp\n ${currentValue}', defaultState: true
        }

		controlTile("thermostatCoolingSetpointSlider", "device.coolingSetpoint", "slider", range: "(20..80)", height: 2, width: 4) {
        	state "coolingSetpoint", action:"setCoolingSetpoint"
		}

		main "A/C Mode"
		details(["initializeLabel", "initialize", "onOffTileLabel", "switch", "A/C Mode", "airConditionerDisplayTile", 
        	"temperatureMeasurementTile", "thermostatCoolingSetpointTile", "thermostatCoolingSetpointSlider"])
	}
}

def initialize() {
	log.debug "initialize()"
	sendEvent(name: "switch", value: "off")
    sendEvent(name: "airConditionerMode", value: "auto")
    sendEvent(name: "coolingSetpoint", value: 70, "unit": "F")
    sendEvent(name: "temperature", value: 88)
}

def installed() {
	log.debug "installed()"
	initialize()
}

def updated() {
	log.debug "updated()"
	installed()
}

def on() {
	log.debug "on()"
	sendEvent(name: "switch", value: "on")
}

def off() {
	log.debug "off()"
	sendEvent(name: "switch", value: "off")
}

def cool() {
	log.debug "cool()"
    sendEvent(name: "airConditionerMode", value: "cool")
}

def dry() {
	log.debug "dry()"
    sendEvent(name: "airConditionerMode", value: "dry")
}

def coolClean() {
	log.debug "coolClean()"
    sendEvent(name: "airConditionerMode", value: "coolClean")
}

def auto() {
	log.debug "auto()"
    sendEvent(name: "airConditionerMode", value: "auto")
}

def setCoolingSetpoint( val ) {
	log.debug "setCoolingSetpoint( ${val} )"
    sendEvent( name: "coolingSetpoint", value: val )
    // none of the code below this line works
//	device.setCoolingSetpoint( ["value": val] )
}
