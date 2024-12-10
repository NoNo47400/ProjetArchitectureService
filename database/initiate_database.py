import subprocess

# Commande MySQL
command = [
    "mysql",
    "-h", "srv-bdens.insa-toulouse.fr",
    "--port=3306",
    "-u", "projet_gei_037",
    "-pOo3Loh1g",  # Attention : inclure le mot de passe en ligne de commande est risqué
    "projet_gei_037",
    "<", "init.sql"
]

try:
    # Exécuter la commande
    result = subprocess.run(
        " ".join(command),
        shell=True,  # Nécessaire pour utiliser "<" avec subprocess
        check=True,
        text=True
    )
    print("Commande exécutée avec succès.")
except subprocess.CalledProcessError as e:
    print(f"Erreur lors de l'exécution de la commande : {e}")