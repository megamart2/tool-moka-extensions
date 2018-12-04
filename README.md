# [![MegaM@Rt](images/megamart2-logo.gif)](https://megamart2-ecsel.eu/) MegaM@Rt project: Moka Extensions

This repository contains the code of number of plugins that extend the functionality of Papyrus Moka engine for fUML simulation. It also contains an update site to install them.

## MegaM@Rt Extensions for Moka

- eu.megamart2.moka.logging:
- eu.megamart2.moka.validation:

## Installation
The installation of the MegaM@Rt Extensions for Moka follows the standard Eclipse plugin installation precedure.

### Requirements
MegaM@Rt Extensions for Moka require the following software requirements:
- Git
- Eclipse 2018-09 Modeling (or above)
- Papyrus
- Moka

Install Git, Eclipse 2018-09 Modeling, Papyrus and Moka before proceedding to install these Moka extensions. 

Note: Eclipse needs to be configured with a default JRE instalation pointed to a JDK (not to a JRE)

### Installation precedure
1. In a command line interface (CMI), pull the **MegaM@Rt Extensions for Moka Repository** to get the update site locally:
`git clone https://gitlab.atosresearch.eu/ari/megamart2-moka.git`
This will create a *megamart2-moka* folder into your local file system

2. In Eclipse, select the top-menu Help/Install New Software. In the Install Wizard, select the Add... button to create a new local repository. Give a name and select the Local... button. Browse your local file system to the Git repository created in previous step. Select the *megamart2-moka/Site/eu.megamart2.moka.extensions.site* folder


![MegaM@Rt Extensions for Moka installation step 2](images/megamart-moka-install_1.png)


3. In Install wizard, select the *MegaM@Rt Extension for Moka* feature, and click on next. Follow next steps, acepting the license and finish. Accept new popup windows that may appear to accept the installation. Restart Eclipse when prompted.

![MegaM@Rt Extensions for Moka installation step 3](images/megamart-moka-install_2.png)

## User Manual

## Validation of executable UML models (fUML comliance).

1. Create a new Papyrus model, selecting *Executable UML* context in first wizard page. Give a project name in next page and finish the wizard.
2. Select the created project in the Project Explorer. Remove the created model (the three files with extensions di, notation, uml). Copy the *Authentication* model files located in *megamart2-moka/Plugins/eu.megamart2.moka.validation/model_examples* into this project folder
3. Open the model into the Papyrus editor by double-clicking in the *Authentication.di* file shown in the project explorer. In Papyrus view, welcome tab, click on *AuthenticationEngineClassifierBehavior* to open the model behavior view.
4. Right click on the Papyrus model graphical view. Select *Validation/Validate Model*.
5. The results of the Moka validation are shown in the *Model Validation View*. New validation constraints added by MegaM@Rt are prefixed with "Moka_"

![Moka validation view](images/moka-validation-view.png)

Validation results are marked for affected model elements on the *Model Explorer* view of the *Papyrus Perspective*, and also in the graphical model view. If you double click on an validation issue in the *Model Validation* view, the corresponding element is highlighted in the model explorer. After fixin each validation issue you can validate again the model and check the results. 

Main contact: Jesús Gorroñogoitia <jesus.gorronogoitia@atos.net>

![Project funded by the European Union](images/european.union.logo.png)
