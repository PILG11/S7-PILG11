# -*- mode: ruby -*-
# vi: set ft=ruby :
# -*- mode: ruby -*-
# vi: set ft=ruby :

#Vagrant.configure("2") do |config|
  # Use the latest version of Ubuntu as the base image
  #config.vm.box = "ubuntu/focal64"

  # Enable network access to the VM
  #config.vm.network "forwarded_port", guest: 80, host: 8080
  #config.vm.network "private_network", ip: "192.168.33.10"

  # Set the hostname of the VM
  #config.vm.hostname = "my-vm"

  # Enable SSH access to the VM
 # config.vm.provision "shell", inline: <<-SHELL
    # Update the package index
   # sudo apt-get update

    # Install the OpenSSH server
   # sudo apt-get install -y openssh-server

    # Configure the OpenSSH server
  #  sudo sed -i 's/^PasswordAuthentication .*/PasswordAuthentication no/' /etc/ssh/sshd_config
   # sudo sed -i 's/^#PasswordAuthentication .*/PasswordAuthentication no/' /etc/ssh/sshd_config
   # sudo systemctl restart ssh
  #SHELL

  # Configure SSH access to the VM
  #config.ssh.insert_key = false
  #config.ssh.private_key_path = ["~/.ssh/id_

Vagrant.configure("2") do |config|
  # Serveur virtuel du site web
  config.vm.define "srv-web" do |machine|
    machine.vm.hostname = "srv-web"
    machine.vm.box = "chavinje/fr-bull-64"
    machine.vm.network :private_network, ip: "192.168.56.80"
    machine.vm.network :forwarded_port, guest: 3000, host: 3000
    # Un repertoire partagé est un plus mais demande beaucoup plus
    # de travail - a voir à la fin
    #machine.vm.synced_folder "./data", "/vagrant_data", SharedFoldersEnableSymlinksCreate: false

    machine.vm.provider :virtualbox do |v|
      v.customize ["modifyvm", :id, "--name", "srv-web"]
      v.customize ["modifyvm", :id, "--groups", "/S7-projet"]
      v.customize ["modifyvm", :id, "--cpus", "2"]
      v.customize ["modifyvm", :id, "--memory", 2*1024]
      v.customize ["modifyvm", :id, "--natdnshostresolver1", "off"]
      v.customize ["modifyvm", :id, "--natdnsproxy1", "off"]
    end
    machine.vm.provision "shell", path: "scripts/install_sys.sh"
    machine.vm.provision "shell", path: "scripts/install_web.sh"
    machine.vm.provision "shell", path: "scripts/install_bdd.sh"
    machine.vm.provision "shell", path: "scripts/install_moodle.sh"
    machine.vm.provision "shell", path: "scripts/install_myadmin.sh"
  end

  # Serveur virtuel de la base de données
  config.vm.define "db" do |db|
    db.vm.hostname = "db"
    db.vm.box = "chavinje/fr-bull-64"
    db.vm.network :private_network, ip: "192.168.56.81"
    db.vm.network :forwarded_port, guest: 3306, host: 3306
    
    db.vm.provider :virtualbox do |v2|
      v2.customize ["modifyvm", :id, "--name", "db"]
      v2.customize ["modifyvm", :id, "--groups", "/S7-projet"]
      v2.customize ["modifyvm", :id, "--cpus", "1"]
      v2.customize ["modifyvm", :id, "--memory", 1024]
      v2.customize ["modifyvm", :id, "--natdnshostresolver1", "off"]
      v2.customize ["modifyvm", :id, "--natdnsproxy1", "off"]
    end
  end

  config.vm.provision "shell", inline: <<-SHELL
      sed -i 's/ChallengeResponseAuthentication no/ChallengeResponseAuthentication yes/g' /etc/ssh/sshd_config    
      sleep 3
      service ssh restart
    SHELL
end
