# Generated by Buildr 1.4.17, change to your liking


# Version number for this release
VERSION_NUMBER = "0.2.1"
# Group identifier for your projects
GROUP = "LoCALISM"
COPYRIGHT = "François Cabrol"

# Define java leap library path
LEAP_LIB_PATH = "lib/leap_v2"
LEAPJAVA = Dir[LEAP_LIB_PATH + '/LeapJava.jar']


# Specify Maven 2.0 remote repositories here, like this:
repositories.remote << "http://repo1.maven.org/maven2"

Project.local_task :run

desc "The Localism project"
define "LoCALISM" do

  project.version = VERSION_NUMBER
  project.group = GROUP
  manifest["Implementation-Vendor"] = COPYRIGHT

  define "Localism" do
    compile.with LEAPJAVA
    package(:jar)
  end

  define "MouseExample" do
    compile.with projects("Localism"), LEAPJAVA
    package(:jar)
  end

  task :run => :compile do
    system 'java -cp MouseExample/target/classes:Localism/target/classes:' + LEAP_LIB_PATH + '/LeapJava.jar -Djava.library.path=' + LEAP_LIB_PATH + ' com.cabrol.francois.localism.example.mouse.Localism'
  end

end
