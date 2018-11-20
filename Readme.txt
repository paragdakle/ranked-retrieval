CS 6322 - Information Retrieval Fall 2018
Author: Parag Pravin Dakle
NetId: pxd160530
Homework 3 Readme

Problem - Ranked Retrieval

1. How to run the program?
Execute the following command from inside the project directory:
./retrieval.sh <path_to_corpus> <path_to_queries_file> <path_to_stopwords_file>

where -
<path_to_corpus>: Path of the directory where the Cranfield collection is present.
<path_to_queries_file>: Path of the file containing queries.
<path_to_stopwords_file>: Path to the file containing stopwords.

2. Sample Execution:
Command: ./retrieval.sh Cranfield/ /people/cs/s/sanda/cs6322/hw3.queries /people/cs/s/sanda/cs6322/resourcesIR/stopwords
Output: (Document vectors are not included here but will be printed in the output)

A. W1 Weight Scheme
Query 1 (Term:TF-IDF Weights) 
------------------------------------------------------
                  high    0.2039                   law    0.3451                  obey    0.3451
            similarity    0.3451              aircraft    0.2039                  must    0.3451
                 model    0.3451                heated    0.3451             construct    0.3451
           aeroelastic    0.2039                 speed    0.2039

Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.190829    cranfield0573            viscous hypersonic similitude .
2.       0.157329    cranfield0013            similarity laws for stressing heated wings .
3.       0.146607    cranfield0944            one dimensional heat conduction through the skin of a vehicle upon entering a planetary atmosphere at constant velocity and entry angle .
4.       0.136278    cranfield0051            theory of aircraft structural models subjected to aerodynamic heating and external loads .
5.       0.120019    cranfield0359            note on the hypersonic similarity law for an unyawed cone .

Query 2 (Term:TF-IDF Weights) 
------------------------------------------------------
                flight    0.4745                  high    0.2803               problem    0.1016
            structural    0.4745              aircraft    0.2803           aeroelastic    0.2803
             associate    0.4745                 speed    0.2803
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.167287    cranfield0012            some structural and aerelastic considerations of highspeed flight .
2.       0.129019    cranfield0051            theory of aircraft structural models subjected to aerodynamicheating and external loads .
3.       0.121166    cranfield0884            the estimation of fatigue damage on structural elements .
4.       0.103178    cranfield0875            models for aeroelastic investigation .
5.       0.100571    cranfield1170            structural loads surveys on two tilt-wing vtol configurations .

Query 3 (Term:TF-IDF Weights) 
------------------------------------------------------
                  heat    0.2336               problem    0.0847             composite    0.3954
                   far    0.3954            conduction    0.3954                 solve    0.3954
                    so    0.3954                  slab    0.3954
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.396531    cranfield0485            linear heat flow in a composite slab .
2.       0.329614    cranfield0005            one-dimensional transient heat conduction into a double-layerslab subjected to a linear heat input for a small timeinternal .
3.       0.241257    cranfield0399            conduction of heat in composite slabs .
4.       0.226542    cranfield0144            heat flow in composite slabs .
5.       0.200316    cranfield0090            periodic temperature distributions in a two-layer compositeslab .

Query 4 (Term:TF-IDF Weights) 
------------------------------------------------------
            chemically    0.2567             criterion    0.2567                  show    0.2567
                 react    0.2567         instantaneous    0.2567               develop    0.2567
                 local    0.2567                   can    0.0741              solution    0.1517
               mixture    0.2567              chemical    0.1517                   gas    0.1517
            assumption    0.2567                    to    0.0415              validity    0.2567
              simplify    0.2567           equilibrium    0.2567           empirically    0.2567
                  flow    0.0315                  base    0.2567
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.155396    cranfield0166            flow of chemically reacting gas mixtures .
2.       0.146469    cranfield0488            a reaction-rate parameter for gasdynamics of a chemicallyreacting gas mixture .
3.       0.134731    cranfield1189            nonequilibrium flow past a wedge .
4.       0.134126    cranfield1061            turbulent mixing of a rocket exhaust jet with a supersonic stream includingchemical reactions .
5.       0.117766    cranfield1275            flow about an unsteadily rotating disc .

Query 5 (Term:TF-IDF Weights) 
------------------------------------------------------
                system    0.4579               problem    0.0980              chemical    0.2705
            hypersonic    0.4579            applicable    0.4579                    to    0.0740
               kinetic    0.4579           aerodynamic    0.2705
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.147570    cranfield0943            compressible free shear layer with finite initial thickness .
2.       0.108166    cranfield0103            theory of mixing and chemical reaction in the opposedjet diffusion flame .
3.       0.102814    cranfield1032            on the conservativeness of various distributed force systems .
4.       0.098109    cranfield0625            viscous and inviscid nonequilibrium gas flows .
5.       0.091772    cranfield0102            advantages and limitations of models .

Query 6 (Term:TF-IDF Weights) 
------------------------------------------------------
             turbulent    0.3852           theoretical    0.3852          experimental    0.2276
               couette    0.3852             behaviour    0.3852                    do    0.2276
                    to    0.0622                 guide    0.3852                    we    0.3852
                  flow    0.0473
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.148432    cranfield0386            a generalised porous-wall ?couette type? flow .
2.       0.146730    cranfield0385            on a generalised porous-wall ?couette type? flow .
3.       0.128768    cranfield0491            on the close relationship between turbulent plane-couetteand pressure flows .
4.       0.115011    cranfield0130            the behaviour of non-linear systems .
5.       0.114971    cranfield0775            studies on two dimensional flows of compressible fluid.

Query 7 (Term:TF-IDF Weights) 
------------------------------------------------------
            equivalent    0.2964               surface    0.2964                 lower    0.2964
             available    0.0855              possible    0.1751              pressure    0.1722
          distribution    0.1751                 ogive    0.4294              forebody    0.4294
                  zero    0.2964                relate    0.2964                    at    0.1722
                attack    0.1722                 angle    0.1722                    to    0.0694

Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.317393    cranfield0492            prediction of ogive-forebody pressures at angles of attack .
2.       0.234181    cranfield0434            contributions of the wing panels to the forces andmoments of supersonic wing-body combinations at combinedangles .
3.       0.207408    cranfield0057            applicability of the hypersonic similarity rule topressure distributions which include the effects ofrotation for bodies of revolution at zero angle ofattack .
4.       0.193692    cranfield0973            interaction effects produced by jet exhausting laterally near base ofogive-cylinder model in supersonic main stream .
5.       0.167903    cranfield0124            a summary of the supersonic pressure drag of bodiesof revolution .

Query 8 (Term:TF-IDF Weights) 
------------------------------------------------------
                    at    0.1426                method    0.3556             presently    0.3556
                attack    0.1426           approximate    0.3556                 exact    0.3556
             available    0.1026               predict    0.3556                 angle    0.1426
              pressure    0.1426                  dash    0.5152                  body    0.1026

Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.154663    cranfield1083            an investigation of fluid flow in two dimensions .
2.       0.134733    cranfield0556            numerical comparison between exact and approximatetheories of hypersonic inviscid flow past slender bluntnosed bodies .
3.       0.131112    cranfield0019            an investigation of the pressure distribution on conical bodies inhypersonic flows .
4.       0.114884    cranfield0569            an experimental investigation of leading edge shock wave boundary layerinteraction at mach 5.8 .
5.       0.106181    cranfield0443            calculated and measured pressure distributions over the midspan sectionof the naca 4412 airfoil .

Query 9 (Term:TF-IDF Weights) 
------------------------------------------------------
                  heat    0.2721              internal    0.4606                 study    0.4606
              transfer    0.4606                  slip    0.4606                papers    0.2721
                  flow    0.0566
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.226375    cranfield0306            second approximation to laminar compressible boundarylayer on flat plate in slip flow .
2.       0.168883    cranfield0021            on heat transfer in slip flow .
3.       0.148469    cranfield0550            laminar heat transfer in tubes under slip-flow conditions .
4.       0.145992    cranfield0022            on slip-flow heat transfer to a flat plate .
5.       0.138329    cranfield0326            forst-order slip effects on the compressible laminarboundary layer over a slender body of revolution inaxial flow .

Query 10 (Term:TF-IDF Weights) 
------------------------------------------------------
                  over    0.3375                  wide    0.3375               density    0.3375
                   gas    0.1994              property    0.1994             available    0.0974
                 range    0.3375                  real    0.3375             transport    0.3375
                   air    0.3375              enthalpy    0.3375
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.161110    cranfield0493            real-gas laminar boundary layer skin friction and heattransfer .
2.       0.144835    cranfield0302            approximations for the thermodynamic and transport properties of hightemperature air .
3.       0.129377    cranfield0949            charts for equilibrium flow properties of air in hypervelocitynozzles .
4.       0.113794    cranfield1143            a one-foot hypervelocity shock tunnel in which high-enthalpyreal gas flows can be generated with flow times ofabout 180 milliseconds .
5.       0.110235    cranfield0332            similitude of hypersonic real-gas flows over slenderbodies with blunted noses .

Query 11 (Term:TF-IDF Weights) 
------------------------------------------------------
               similar    0.3510                strong    0.3510         approximation    0.3510
               problem    0.0752            analytical    0.3510              solution    0.2073
                  find    0.3510             newtonian    0.3510              possible    0.2073
                    to    0.0567                  wave    0.2073                 blast    0.3510

Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.304305    cranfield0495            on similar solutions for strong blast waves and theirapplication to steady hypersonic flow .
2.       0.122078    cranfield0305            hypersonic strong viscous interaction on a flat platewith surface mass transfer .
3.       0.120240    cranfield0654            on the propagation and structure of the blast wave . part 1.
4.       0.117492    cranfield1327            on the propagation and structure of the blast wave .
5.       0.112041    cranfield0072            boundary layer behind shock or thin expansion wavemoving into stationary fluid .

Query 12 (Term:TF-IDF Weights) 
------------------------------------------------------
                   can    0.1272           performance    0.4408               machine    0.4408
                effect    0.2604               channel    0.4408                ground    0.4408
             calculate    0.2604           aerodynamic    0.2604                  flow    0.0541

Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.206496    cranfield0624            cruise performance of channel-flow ground effect machines .
2.       0.195093    cranfield0650            some design problems of hovercraft .
3.       0.193822    cranfield0941            viscous compressible and incompressible flow in slenderchannels .
4.       0.157218    cranfield1221            steady flow of conducting fluids in channels undertransverse magnetic fields, with consideration of halleffect .
5.       0.136994    cranfield0966            on fully developed channel flows,. some solutions and limitations, andeffects of compressibility, variable properties, and body forces .

Query 13 (Term:TF-IDF Weights) 
------------------------------------------------------
             transonic    0.4795               aileron    0.4795                 basic    0.2833
             mechanism    0.4795                  buzz    0.4795
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.463553    cranfield0496            a theory of transonic aileron buzz, neglecting viscouseffects .
2.       0.248523    cranfield0903            two dimensional transonic unsteady flow with shockwaves .
3.       0.159712    cranfield0038            on the prediction of mixed subsonic/supersonic pressuredistributions .
4.       0.145834    cranfield0520            wing-tail interference as a cause of 'magnus' effectson a finned missile .
5.       0.140683    cranfield0643            an investigation of wing-aileron flutter using groundlaunched rocket models .

Query 14 (Term:TF-IDF Weights) 
------------------------------------------------------
                 shock    0.5200                 sound    0.5200           interaction    0.5200
                papers    0.3072                  wave    0.3072
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.155988    cranfield0064            unsteady oblique interaction of a shock wave with planedisturbances .
2.       0.116766    cranfield0291            sweepback effects in the turbulent boundary-layer shock-waveinteraction .
3.       0.110857    cranfield0568            shock wave effects on the laminar skin friction ofan insulated flat plate at hypersonic speeds .
4.       0.106512    cranfield0124            a summary of the supersonic pressure drag of bodiesof revolution .
5.       0.102705    cranfield0256            an experimental study of the glancing interaction betweena shock wave and a turbulent boundary layer .

Query 15 (Term:TF-IDF Weights) 
------------------------------------------------------
              material    0.7803              property    0.3181          photoelastic    0.5385

Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.246350    cranfield0462            photo-thermoelasticity .
2.       0.136124    cranfield1099            a theoretical study of stagnation point ablation .
3.       0.113377    cranfield0761            buckling of sandwich under normal pressure .
4.       0.109189    cranfield1025            note on creep buckling of columns .
5.       0.102425    cranfield1043            on transverse vibrations of thin, shallow elastic shells .

Query 16 (Term:TF-IDF Weights) 
------------------------------------------------------
                   can    0.1326              computer    0.4594            transverse    0.2714
                 about    0.2714           efficiently    0.4594            electronic    0.4594
             calculate    0.2714                  body    0.1326             potential    0.2714
            revolution    0.1842                  flow    0.0564
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.287834    cranfield0498            calculation of potential flow about bodies of revolutionhaving axes perpendicular to the free-stream direction .
2.       0.193256    cranfield0093            the supersonic blunt body problem - review and extensions .
3.       0.159500    cranfield1006            free-flight measurements of the static and dynamic
4.       0.141528    cranfield1286            equilibrium real-gas performance charts for a shypersonicshock-tube wind-tunnel employing nitrogen .
5.       0.113174    cranfield0869            the calculation of transient temperature in turbineblades and tapered discs using biot's variational method .

Query 17 (Term:TF-IDF Weights) 
------------------------------------------------------
                reduce    0.3889           dimensional    0.5635            transverse    0.2298
                 about    0.2298                  body    0.1123                 three    0.3889
            revolution    0.1560                   two    0.3889                   can    0.1123
               problem    0.1207                    to    0.0628             potential    0.2298
                  flow    0.0478
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.095357    cranfield0336            simplified laminar boundary layer calculations forbodies of revolution and for yawed wings .
2.       0.091834    cranfield0916            the flow around oscillating low aspect ratio wings at transonicspeeds .
3.       0.089987    cranfield0372            an experimental investigation of flow about simpleblunt bodies at a nominal mach number of 5. 8.
4.       0.085820    cranfield1281            turbulent heat transfer on blunt-nosed bodies in two-dimensionaland general three-dimensional hypersonic flow .
5.       0.085698    cranfield0106            the transverse potential flow past a body of revolution .

Query 18 (Term:TF-IDF Weights) 
------------------------------------------------------
                    at    0.3104                attack    0.3104             available    0.2234
                 angle    0.3104          experimental    0.4573              pressure    0.3104
          distribution    0.4573                  body    0.2234            revolution    0.3104

Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.112024    cranfield0498            calculation of potential flow about bodies of revolutionhaving axes perpendicular to the free-stream direction .
2.       0.102538    cranfield0248            the application of lighthill formula for numericalcalculation of pressure distributions on bodies ofrevolution at supersonic speed and zero angle of attack .
3.       0.101854    cranfield1006            free-flight measurements of the static and dynamic
4.       0.099569    cranfield0197            pressure distributions on three bodies of revolutionto determine the effect of reynolds number up to andincluding the transonic speed range .
5.       0.097741    cranfield0056            an analysis of the applicability of the hypersonicsimilarity law to the study of the flow about bodiesof revolution at zero angle of attack .

Query 19 (Term:TF-IDF Weights) 
------------------------------------------------------
             treatment    0.2768            simplicity    0.2768                    do    0.1636
                  good    0.2768                 exist    0.2768                result    0.2768
                 entry    0.2768              dynamics    0.2768                    re    0.2768
             realistic    0.2768                effect    0.1636         consideration    0.2768
                 basic    0.1636               combine    0.2768              relative    0.2768

Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.102261    cranfield0082            theoretical investigation of the ablation of a glass-typeheat protection shield of varied material propertiesat the stagnation point of a re-entering irbm .
2.       0.093816    cranfield0482            a re-examination of the use of the simple conceptsfor prediction the shape and location of detached shockwaves .
3.       0.086354    cranfield0027            newtonian flow theory for slender bodies .
4.       0.082487    cranfield1119            plastic stability theory of thin shells .
5.       0.079019    cranfield0903            two dimensional transonic unsteady flow with shockwaves .

Query 20 (Term:TF-IDF Weights) 
------------------------------------------------------
                 joule    0.2581             determine    0.2581               produce    0.2581
             influence    0.2581            convection    0.2581               general    0.2581
                induce    0.2581               current    0.2581             condition    0.2581
                anyone    0.2581   magnetohydrodynamic    0.2581               heating    0.2581
                  free    0.2581                 under    0.2581              formally    0.2581
                  flow    0.0317
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.273575    cranfield0500            joule heating in magnetohydrodynamic free-convectionflows .
2.       0.149454    cranfield0268            several magnetohydrodynamic free-convection solutions .
3.       0.109067    cranfield0584            conduction of heat in a solid with a power law of heattransfer at its surface .
4.       0.090229    cranfield0458            a new series for calculation of steady laminar boundarylayer flows .
5.       0.089257    cranfield0450            some physical interpretations of magnetohydrodynamic duct flows .

------------------------------------------------------
B. W2 Weight Scheme
Query 1 (Term:TF-IDF Weights) 
------------------------------------------------------
                  high    0.3361                   law    0.2799                  obey    0.2799
            similarity    0.2799              aircraft    0.3361                  must    0.2799
                 model    0.2799                heated    0.2799             construct    0.2799
           aeroelastic    0.3361                 speed    0.3361
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.160144    cranfield0141            free-flight techniques for high speed aerodynamic research .
2.       0.144220    cranfield0429            a description of the r. a. e.  high speed supersonictunnel .
3.       0.130764    cranfield0879            flutter model testing at transonic speeds .
4.       0.116866    cranfield0578            dissociation scaling for nonequilibrium blunt nose flows .
5.       0.114618    cranfield1111            some research on high speed flutter .

Query 2 (Term:TF-IDF Weights) 
------------------------------------------------------
                flight    0.2925                  high    0.3484               problem    0.5078
            structural    0.2925              aircraft    0.3484           aeroelastic    0.3484
             associate    0.2925                 speed    0.3484
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.266147    cranfield0429            a description of the r. a. e.  high speed supersonictunnel .
2.       0.221077    cranfield0578            dissociation scaling for nonequilibrium blunt nose flows .
3.       0.170525    cranfield0672            tunnel interference effects .
4.       0.168817    cranfield0607            duct flow in magnetohydrodynamics .
5.       0.163150    cranfield0108            properties of the confluent hypergeometric function .

Query 3 (Term:TF-IDF Weights) 
------------------------------------------------------
                  heat    0.3687               problem    0.5374             composite    0.3096
                   far    0.3096            conduction    0.3096                 solve    0.3096
                    so    0.3096                  slab    0.3096
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.209841    cranfield0350            laminar jet mixing of two compressible fluids with heat release .
2.       0.153338    cranfield0145            skin friction in the laminar boundary layer in compressibleflow .
3.       0.144202    cranfield1389            numerical construction of detached shock waves .
4.       0.136898    cranfield0607            duct flow in magnetohydrodynamics .
5.       0.123464    cranfield0429            a description of the r. a. e.  high speed supersonictunnel .

Query 4 (Term:TF-IDF Weights) 
------------------------------------------------------
            chemically    0.1791             criterion    0.1791                  show    0.1791
                 react    0.1791         instantaneous    0.1791               develop    0.1791
                 local    0.1791                   can    0.2930              solution    0.2189
               mixture    0.1791              chemical    0.2189                   gas    0.2189
            assumption    0.1791                    to    0.3760              validity    0.1791
              simplify    0.1791           equilibrium    0.1791           empirically    0.1791
                  flow    0.4243                  base    0.1791
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.472324    cranfield1189            nonequilibrium flow past a wedge .
2.       0.470799    cranfield1255            the flow about a charged body moving in the lower atmosphere .
3.       0.466150    cranfield0167            linearized flow of a dissociating gas .
4.       0.465936    cranfield1374            theoretical analysis of turbulent mixing of reactivegases with application to supersonic combustion ofhydrogen .
5.       0.465769    cranfield1085            note on the convergence of numerical solutions of the navier-stokesequations .

Query 5 (Term:TF-IDF Weights) 
------------------------------------------------------
                system    0.2709               problem    0.4703              chemical    0.3226
            hypersonic    0.2709            applicable    0.2709                    to    0.5264
               kinetic    0.2709           aerodynamic    0.3226
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.555565    cranfield0650            some design problems of hovercraft .
2.       0.546267    cranfield1379            hypersonic flight and the re-entry problem .
3.       0.544384    cranfield0281            higher order approximations for relaxation oscillations .
4.       0.542661    cranfield1030            note on creep buckling of columns .
5.       0.539344    cranfield0451            liapunov's methods in automatic control theory .

Query 6 (Term:TF-IDF Weights) 
------------------------------------------------------
             turbulent    0.2377           theoretical    0.2377          experimental    0.2847
               couette    0.2377             behaviour    0.2377                    do    0.2847
                    to    0.4701                 guide    0.2377                    we    0.2377
                  flow    0.5271
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.557429    cranfield0418            transition form laminar to turbulent shear flow .
2.       0.548241    cranfield0544            a theoretical and experimental study of oscillating wedge shapedaerofoils in hypersonic flow .
3.       0.544199    cranfield0295            a note on transitional heat transfer under hypersonic conditions .
4.       0.543521    cranfield0121            a theory for base pressures in transonic and supersonicflow .
5.       0.543126    cranfield0453            the influence of two-dimensional stream shear on airfoil maximum lift .

Query 7 (Term:TF-IDF Weights) 
------------------------------------------------------
            equivalent    0.1865               surface    0.1865                 lower    0.1865
             available    0.3071              possible    0.2287              pressure    0.2973
          distribution    0.2287                 ogive    0.2162              forebody    0.2162
                  zero    0.1865                relate    0.1865                    at    0.2973
                attack    0.2973                 angle    0.2973                    to    0.4245

Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.518952    cranfield0694            pressure distribution induced on a flat plate by a supersonic and sonicjet exhaust at a free-stream mach number of 1.80 .
2.       0.516934    cranfield0248            the application of lighthill formula for numericalcalculation of pressure distributions on bodies ofrevolution at supersonic speed and zero angle of attack .
3.       0.515249    cranfield0693            investigation of jet effects on a flat surface downstream of the exit of a simulated turbojet nacelle at a free-stream mach number of 1.39 .
4.       0.515140    cranfield0057            applicability of the hypersonic similarity rule topressure distributions which include the effects ofrotation for bodies of revolution at zero angle ofattack .
5.       0.514302    cranfield1378            blunt-cone pressure distributions at hypersonic mach numbers .

Query 8 (Term:TF-IDF Weights) 
------------------------------------------------------
                    at    0.3186                method    0.2280             presently    0.2280
                attack    0.3186           approximate    0.2280                 exact    0.2280
             available    0.3628               predict    0.2280                 angle    0.3186
              pressure    0.3186                  dash    0.2661                  body    0.3628

Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.495356    cranfield0492            prediction of ogive-forebody pressures at angles of attack .
2.       0.344294    cranfield1006            free-flight measurements of the static and dynamic
3.       0.300340    cranfield0019            an investigation of the pressure distribution on conical bodies inhypersonic flows .
4.       0.294680    cranfield1306            experiments on circular cones at yaw in supersonicflow .
5.       0.288809    cranfield0124            a summary of the supersonic pressure drag of bodiesof revolution .

Query 9 (Term:TF-IDF Weights) 
------------------------------------------------------
                  heat    0.3508              internal    0.2956                 study    0.2956
              transfer    0.2956                  slip    0.2956                papers    0.3508
                  flow    0.6359
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.440509    cranfield0021            on heat transfer in slip flow .
2.       0.356836    cranfield0507            energy equation approximations in fluid mechanics .
3.       0.350343    cranfield1073            a practical method for numerical evaluation of solutionsof partial differential equations of the heat-conductiontype .
4.       0.345239    cranfield0333            boundary-layer interaction on a yawed infinite wing in hypersonicflow .
5.       0.330576    cranfield0607            duct flow in magnetohydrodynamics .

Query 10 (Term:TF-IDF Weights) 
------------------------------------------------------
                  over    0.2736                  wide    0.2736               density    0.2736
                   gas    0.3285              property    0.3285             available    0.4308
                 range    0.2736                  real    0.2736             transport    0.2736
                   air    0.2736              enthalpy    0.2736
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.323672    cranfield0405            tables of thermal properties of gases .
2.       0.122871    cranfield1143            a one-foot hypervelocity shock tunnel in which high-enthalpyreal gas flows can be generated with flow times ofabout 180 milliseconds .
3.       0.121501    cranfield0125            measurements of skin friction of the compressible turbulentboundary layer on a cone with foreign gas injection .
4.       0.109197    cranfield1227            pressure-gradient effects on the preston tube in supersonicflow .
5.       0.097926    cranfield0437            hypervelocity stagnation point heat transfer .

Query 11 (Term:TF-IDF Weights) 
------------------------------------------------------
               similar    0.2321                strong    0.2321         approximation    0.2321
               problem    0.4145            analytical    0.2321              solution    0.2794
                  find    0.2321             newtonian    0.2321              possible    0.2794
                    to    0.4659                  wave    0.2794                 blast    0.2321

Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.526906    cranfield0472            waves in supersonic flow .
2.       0.516600    cranfield0495            on similar solutions for strong blast waves and theirapplication to steady hypersonic flow .
3.       0.509042    cranfield1206            magnetohydrodynamic mach cones .
4.       0.507598    cranfield0745            an automatic method for finding the greatest or leastvalue function .
5.       0.507450    cranfield0072            boundary layer behind shock or thin expansion wavemoving into stationary fluid .

Query 12 (Term:TF-IDF Weights) 
------------------------------------------------------
                   can    0.3949           performance    0.2538               machine    0.2538
                effect    0.3031               channel    0.2538                ground    0.2538
             calculate    0.3031           aerodynamic    0.3031                  flow    0.5575

Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.363375    cranfield0775            studies on two dimensional flows of compressible fluid.
2.       0.330447    cranfield0590            effects of stage characteristics and matching on axial flow compressorperformance .
3.       0.325316    cranfield1142            effect of wall divergence on sonic flows in solid walltunnels .
4.       0.317745    cranfield0750            transonic flow in two dimensional and axially symmetricalnozzles .
5.       0.312381    cranfield0450            some physical interpretations of magnetohydrodynamic duct flows .

Query 13 (Term:TF-IDF Weights) 
------------------------------------------------------
             transonic    0.4308               aileron    0.4308                 basic    0.5077
             mechanism    0.4308                  buzz    0.4308
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.083685    cranfield0880            the design and testing of supersonic flutter models .
2.       0.060667    cranfield0879            flutter model testing at transonic speeds .
3.       0.050513    cranfield0853            the accuracy of donnell's equations .
4.       0.049356    cranfield0795            the operation of the npl 18in x 14in. wind tunnel in the transonic speed range .
5.       0.042794    cranfield0577            on hypersonic similitude .

Query 14 (Term:TF-IDF Weights) 
------------------------------------------------------
                 shock    0.4160                 sound    0.4160           interaction    0.4160
                papers    0.4903                  wave    0.4903
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.223382    cranfield0064            unsteady oblique interaction of a shock wave with planedisturbances .
2.       0.175197    cranfield0291            sweepback effects in the turbulent boundary-layer shock-waveinteraction .
3.       0.170552    cranfield0071            laminar boundary layer behind shock advancing intostationary fluid .
4.       0.153668    cranfield0482            a re-examination of the use of the simple conceptsfor prediction the shape and location of detached shockwaves .
5.       0.153575    cranfield1389            numerical construction of detached shock waves .

Query 15 (Term:TF-IDF Weights) 
------------------------------------------------------
              material    0.5963              property    0.6111          photoelastic    0.5206

Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.170590    cranfield0405            tables of thermal properties of gases .
2.       0.137405    cranfield1099            a theoretical study of stagnation point ablation .
3.       0.081854    cranfield0108            properties of the confluent hypergeometric function .
4.       0.071277    cranfield1269            a study of supersonic combustion .
5.       0.071213    cranfield0609            on three dimensional bodies of delta planform whichcan support plane attached shock waves .

Query 16 (Term:TF-IDF Weights) 
------------------------------------------------------
                   can    0.3465              computer    0.2200            transverse    0.2642
                 about    0.2642           efficiently    0.2200            electronic    0.2200
             calculate    0.2642                  body    0.3465             potential    0.2642
            revolution    0.3051                  flow    0.4922
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.319880    cranfield0775            studies on two dimensional flows of compressible fluid.
2.       0.299692    cranfield0161            supersonic flow past a family of blunt symmetric bodies .
3.       0.294511    cranfield0326            forst-order slip effects on the compressible laminarboundary layer over a slender body of revolution inaxial flow .
4.       0.290168    cranfield0607            duct flow in magnetohydrodynamics .
5.       0.287842    cranfield1006            free-flight measurements of the static and dynamic

Query 17 (Term:TF-IDF Weights) 
------------------------------------------------------
                reduce    0.1847           dimensional    0.2154            transverse    0.2237
                 about    0.2237                  body    0.2965                 three    0.1847
            revolution    0.2598                   two    0.1847                   can    0.2965
               problem    0.3661                    to    0.3779             potential    0.2237
                  flow    0.4253
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.509401    cranfield1301            compressible boundary layers on bodies of revolution .
2.       0.502269    cranfield0445            on the application of mathieu functions in the theoryof subsonic compressible flow past oscillating airfoils .
3.       0.491057    cranfield0002            simple shear flow past a flat plate in an incompressible fluid of smallviscosity .
4.       0.490617    cranfield1108            a study of second-order supersonic flow theory .
5.       0.479846    cranfield1105            numerical solutions for supersonic flow of an idealgas around blunt two-dimensional bodies .

Query 18 (Term:TF-IDF Weights) 
------------------------------------------------------
                    at    0.3319                attack    0.3319             available    0.3759
                 angle    0.3319          experimental    0.2885              pressure    0.3319
          distribution    0.2885                  body    0.3759            revolution    0.3319

Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.478900    cranfield0492            prediction of ogive-forebody pressures at angles of attack .
2.       0.399694    cranfield1006            free-flight measurements of the static and dynamic
3.       0.393800    cranfield0019            an investigation of the pressure distribution on conical bodies inhypersonic flows .
4.       0.321002    cranfield1062            an experimental and theoretical investigation of second-orderwing-body interference at high mach number .
5.       0.315028    cranfield0430            calibration of the flow in the mach 4 working sectionof the 4ft . x 3ft . high supersonic speed wind tunnelat rae bedford .

Query 19 (Term:TF-IDF Weights) 
------------------------------------------------------
             treatment    0.2469            simplicity    0.2469                    do    0.2992
                  good    0.2469                 exist    0.2469                result    0.2469
                 entry    0.2469              dynamics    0.2469                    re    0.2469
             realistic    0.2469                effect    0.2992         consideration    0.2469
                 basic    0.2992               combine    0.2469              relative    0.2469

Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.178650    cranfield0482            a re-examination of the use of the simple conceptsfor prediction the shape and location of detached shockwaves .
2.       0.172484    cranfield0450            some physical interpretations of magnetohydrodynamic duct flows .
3.       0.153165    cranfield0954            analysis of stress at several junctions in pressurizedshells .
4.       0.152429    cranfield0706            on som reciprocal relations in the theory of nonstationary flows .
5.       0.152367    cranfield0125            measurements of skin friction of the compressible turbulentboundary layer on a cone with foreign gas injection .

Query 20 (Term:TF-IDF Weights) 
------------------------------------------------------
                 joule    0.2215             determine    0.2215               produce    0.2215
             influence    0.2215            convection    0.2215               general    0.2215
                induce    0.2215               current    0.2215             condition    0.2215
                anyone    0.2215   magnetohydrodynamic    0.2215               heating    0.2215
                  free    0.2215                 under    0.2215              formally    0.2215
                  flow    0.5136
Rank     Score       External Doc Identifier  Headline
-------------------------------------------------------------------
1.       0.298382    cranfield0500            joule heating in magnetohydrodynamic free-convectionflows .
2.       0.296044    cranfield0450            some physical interpretations of magnetohydrodynamic duct flows .
3.       0.293250    cranfield0607            duct flow in magnetohydrodynamics .
4.       0.267302    cranfield1149            similar temperature boundary layers .
5.       0.265254    cranfield1194            magnetohydrodynamic flow past a thin airfoil .

------------------------------------------------------
