TorpedoDetector
===============
PROBLEM DESCRIPTION
This is a data analysis problem. 
Your country is being attacked by aliens aboard Spaceship Ravager. Their weapon of choice is a proton torpedo. 
You could counter attack or avoid the torpedos if you knew where they were, but unfortunately, both Spaceship Ravager and the torpedos are invisible to the naked eye! They are hidden by cloaks made of a material called kromon.
You know that more spaceships identical to Ravager are converging and preparing for an attack…
Your only hope is the ‘Detector’, an imaging kromon detection system that provides the only information you have about the locations of enemy spaceships and torpedos. However, the information isn’t perfect.
First, the Detector outputs data that is equivalent of a black and white image. Each pixel where kromon material is detected is ‘on’ and marked with a ‘+’. The Detector only detects kromon at any particular point on an image, not what its intensity is. 
Second, the data is very noisy – even if there are no spaceships or torpedos in a particular area, some pixels will be “on”, and even if there is a spaceship or torpedo, some of its pixels will be “off”. For example, here's a sample of raw data from the Detector (each “+” is a pixel that is ‘on’):
 
Below is a sample image of a proton torpedo:
 
On the Detector data, the pixels that should be “on” for a proton torpedo have been highlighted. You can see that more of the highlighted pixels are “on” in the highlighted area than in other areas of the image. You can use this difference to locate spaceships and torpedos in the Detector data.
