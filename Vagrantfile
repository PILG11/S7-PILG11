# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|
  # Serveur virtuel du site web
  config.vm.define "web1" do |web1|
    web1.vm.hostname = "web1"
    web1.vm.box = "chavinje/fr-bull-64"
    web1.vm.network :private_network, ip: "192.168.56.82"
    web1.vm.network "forwarded_port", guest: 80, host: 8082

    web1.vm.provider :virtualbox do |v1|
      v1.customize ["modifyvm", :id, "--name", "web1"]
      v1.customize ["modifyvm", :id, "--groups", "/S7-projet"]
      v1.customize ["modifyvm", :id, "--cpus", "1"]
      v1.customize ["modifyvm", :id, "--memory", 2*1024]
      v1.customize ["modifyvm", :id, "--natdnshostresolver1", "on"]
      v1.customize ["modifyvm", :id, "--natdnsproxy1", "on"]
    end
    web1.vm.provision "shell", path: "scripts/install/install_sys.sh"
    web1.vm.provision "shell", path: "scripts/install/install_web.sh"
    # web1.vm.provision "shell", path: "scripts/install/install_myadmin.sh"
    web1.vm.provision "shell", path: "scripts/install/install_firewall_web.sh"
  end

  config.vm.define "web2" do |web2|
    web2.vm.hostname = "web2"
    web2.vm.box = "chavinje/fr-bull-64"
    web2.vm.network :private_network, ip: "192.168.56.83"
    web2.vm.network "forwarded_port", guest: 80, host: 8083

    web2.vm.provider :virtualbox do |v2|
      v2.customize ["modifyvm", :id, "--name", "web2"]
      v2.customize ["modifyvm", :id, "--groups", "/S7-projet"]
      v2.customize ["modifyvm", :id, "--cpus", "1"]
      v2.customize ["modifyvm", :id, "--memory", 2*1024]
      v2.customize ["modifyvm", :id, "--natdnshostresolver1", "on"]
      v2.customize ["modifyvm", :id, "--natdnsproxy1", "on"]
    end
    web2.vm.provision "shell", path: "scripts/install/install_sys.sh"
    web2.vm.provision "shell", path: "scripts/install/install_web.sh"
    # web2.vm.provision "shell", path: "scripts/install/install_myadmin.sh"
    web2.vm.provision "shell", path: "scripts/install/install_firewall_web.sh"
  end

  # Serveur virtuel de la base de données
  config.vm.define "db" do |db|
    db.vm.hostname = "db"
    db.vm.box = "chavinje/fr-bull-64"
    db.vm.network :private_network, ip: "192.168.56.81"
    
    db.vm.provider :virtualbox do |v3|
      v3.customize ["modifyvm", :id, "--name", "db"]
      v3.customize ["modifyvm", :id, "--groups", "/S7-projet"]
      v3.customize ["modifyvm", :id, "--cpus", "1"]
      v3.customize ["modifyvm", :id, "--memory", 2*1024]
    end
    db.vm.provision "shell", path: "scripts/install/install_sys.sh"
    db.vm.provision "shell", path: "scripts/install/install_db.sh"
    db.vm.provision "shell", path: "scripts/setup_backup.sh"
    db.vm.provision "shell", path: "scripts/install/install_firewall_db.sh"
  end

  # Serveur virtuel du reverse-proxy
  config.vm.define "reverse-proxy" do |rp|
    rp.vm.hostname = "reverse-proxy"
    rp.vm.box = "chavinje/fr-bull-64"
    rp.vm.network :private_network, ip: "192.168.56.80"
    rp.vm.network "forwarded_port", guest: 443, host: 8443
    rp.vm.network "forwarded_port", guest: 80, host: 9080
    
    rp.vm.provider :virtualbox do |v4|
      v4.customize ["modifyvm", :id, "--name", "rp"]
      v4.customize ["modifyvm", :id, "--groups", "/S7-projet"]
      v4.customize ["modifyvm", :id, "--cpus", "1"]
      v4.customize ["modifyvm", :id, "--memory", 2*1024]
      v4.customize ["modifyvm", :id, "--natdnshostresolver1", "on"]
      v4.customize ["modifyvm", :id, "--natdnsproxy1", "on"]
    end
    rp.vm.provision "shell", path: "scripts/install/install_sys.sh"
    rp.vm.provision "shell", path: "scripts/install/install_rp.sh"
  end

end
  