# -*- mode: ruby -*-
# vi: set ft=ruby :

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
  config.vm.define "web" do |web|
    web.vm.hostname = "web"
    web.vm.box = "chavinje/fr-bull-64"
    web.vm.network :private_network, ip: "192.168.56.80"
    # Un repertoire partagé est un plus mais demande beaucoup plus
    # de travail - a voir à la fin
    #machine.vm.synced_folder "./data", "/vagrant_data", SharedFoldersEnableSymlinksCreate: false

    web.vm.provider :virtualbox do |v|
      v.customize ["modifyvm", :id, "--name", "web"]
      v.customize ["modifyvm", :id, "--groups", "/S7-projet"]
      v.customize ["modifyvm", :id, "--cpus", "1"]
      v.customize ["modifyvm", :id, "--memory", 2*1024]
      v.customize ["modifyvm", :id, "--natdnshostresolver1", "on"]
      v.customize ["modifyvm", :id, "--natdnsproxy1", "off"]
    end
    web.vm.provision "shell", path: "scripts/install_sys.sh"
    web.vm.provision "shell", path: "scripts/install_web.sh"
    web.vm.provision "shell", path: "scripts/install_myadmin.sh"
    # Copier le site web de la machine hôte vers la VM 
    web.vm.provision "file", source: "./Website", destination: "./Website"
    # Copier de la VM vers le root de la VM
    web.vm.provision "shell", inline: "mv ./Website /var/www/html/Website"
  end

  # Serveur virtuel de la base de données
  config.vm.define "db" do |db|
    db.vm.hostname = "db"
    db.vm.box = "chavinje/fr-bull-64"
    db.vm.network :private_network, ip: "192.168.56.81"
    
    db.vm.provider :virtualbox do |v2|
      v2.customize ["modifyvm", :id, "--name", "db"]
      v2.customize ["modifyvm", :id, "--groups", "/S7-projet"]
      v2.customize ["modifyvm", :id, "--cpus", "1"]
      v2.customize ["modifyvm", :id, "--memory", 2*1024]
      v2.customize ["modifyvm", :id, "--natdnshostresolver1", "on"]
      v2.customize ["modifyvm", :id, "--natdnsproxy1", "off"]
    end
    db.vm.provision "shell", path: "scripts/install_sys.sh"
    db.vm.provision "shell", path: "scripts/install_bdd.sh"
    db.vm.provision "shell", path: "scripts/backup_database.sh"
  end

  config.vm.provision "shell", inline: <<-SHELL
      sed -i 's/ChallengeResponseAuthentication no/ChallengeResponseAuthentication yes/g' /etc/ssh/sshd_config    
      sleep 3
      service ssh restart
    SHELL
end
