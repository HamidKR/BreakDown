name := "BreakDown"

version := "1.0"

scalaVersion := "2.12.1"

name := "useSaul"

version := "1.0"

scalaVersion := "2.11.7"


resolvers += "CogcompSoftware" at "http://cogcomp.cs.illinois.edu/m2repo/"
libraryDependencies += "edu.illinois.cs.cogcomp" % "saul-examples_2.11" % "0.5.7"
libraryDependencies += "nz.ac.waikato.cms.weka" % "weka-stable" % "3.8.0"
libraryDependencies += "org.deeplearning4j" % "deeplearning4j-core" % "0.7.2"
libraryDependencies += "org.deeplearning4j" % "deeplearning4j-scaleout-api" % "1.0"
libraryDependencies += "org.deeplearning4j" % "deeplearning4j-nlp" % "0.7.2"
libraryDependencies += "org.nd4j" % "nd4j-native-platform" % "0.7.2"
libraryDependencies += "org.apache.spark" %% "spark-core" % "1.4.1"
//libraryDependencies += "org.jfreechart.version>1.0.13</jfreechart.version>
libraryDependencies += "org.jfree" % "jfreechart" % "1.0.14"
